package ByteDance;

public class Main1 {
    public static void main(String[] args) {
        long n = 10;
        int count = 0;
        while(n != 1){
            double m = sqrtRoot(n);
            if((m * 2)%2 != 0) {
                n--;
                count++;
            } else {
                n = (long)m;
                count++;
            }
        }
        System.out.println(count);
    }

    public static double sqrtRoot(double m) {
        if ( m == 0 ) {
            return 0;
        }

        double i = 0;
        double x1, x2 = 0;
        while ( ( i * i ) <= m ) {
            i += 0.1;
        }
        x1 = i;
        for ( int j = 0; j < 10; j++) {
            x2 = m;
            x2 /= x1;
            x2 += x1;
            x2 /= 2;
            x1 = x2;
        }
        return x2;
    }
}
