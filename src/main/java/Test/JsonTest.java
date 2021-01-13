package Test;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

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
