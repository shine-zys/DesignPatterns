package BaseClass;

import com.google.common.util.concurrent.*;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.*;

public class StaticClass {

    String a = print();
    private final ExecutorService delegateAsyncTransformer = Executors.newCachedThreadPool(new StaticClass.DaemonThreadFactory());
    private final ListeningExecutorService transformerPool;

    private static String print() {
        System.out.println("static class static method print ... ");
        return "aaa";
    }

    public StaticClass() {
        System.out.println("static class ...");
        this.transformerPool = MoreExecutors.listeningDecorator(this.delegateAsyncTransformer);
    }

    public String listDirEx(String key, boolean recursive) throws InterruptedException, ExecutionException, TimeoutException {
        return (String)this.asyncExecute(key).get(20000L, TimeUnit.MILLISECONDS);
    }

    private ListenableFuture<String> asyncExecute(String request) {
        ListenableFuture<String> response = this.asyncExecuteHttp(request);
        return Futures.transformAsync(response, new StaticClass.AsyncTransformation(request, this.transformerPool), MoreExecutors.directExecutor());
    }

    private ListenableFuture<String> asyncExecuteHttp(String request) {
        final SettableFuture<String> future = SettableFuture.create();
        future.set("aaa");
        return future;
    }

    private class AsyncTransformation implements AsyncFunction<String, String> {
        private final ListeningExecutorService transformPool;
        private final String request;

        AsyncTransformation(String request, ListeningExecutorService transformPool) {
            this.request = request;
            this.transformPool = transformPool;
            System.out.println("new StaticClass.AsyncTransformation ... " + this.request);
        }

        @Override
        public ListenableFuture<String> apply(@Nullable String response) throws Exception {
            return this.transformPool.submit(new StaticClass.AsyncTransformation.TransformerWorker(response));
        }

        private class TransformerWorker implements Callable<String> {
            private final String response;

            TransformerWorker(String response) {
                this.response = response;
                System.out.println("static class testClass class innerClass class ... " + this.response);
            }

            @Override
            public String call() throws Exception {
                return "bbb";
            }
        }
    }

    private static class DaemonThreadFactory implements ThreadFactory {
        private DaemonThreadFactory() {
        }

        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        }
    }

}
