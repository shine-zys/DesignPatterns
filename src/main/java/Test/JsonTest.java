package Test;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @anchor zhangyaosheng
 * @desc
 * @date 2020/3/20
 * @time 6:11 下午
 * @copyright douyu.com
 */
@Data
public class JsonTest implements Serializable {


    private int gid;

    private String name;

    private List<Info> list;

    @Data
    private static class Info implements Serializable {

        private int id;

        private String name;
    }
}
