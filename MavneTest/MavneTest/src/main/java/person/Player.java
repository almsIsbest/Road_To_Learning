package person;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import javax.print.attribute.standard.Finishings;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

@Getter
@Setter
public class Player {
    String name;
    @JSONField(serialize = false)
    String icon;
    int type;

    public Player(String name, String icon, int type) {
        this.name = name;
        this.icon = icon;
        this.type = type;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(10000);

    }
    public static void readFile(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        byte[] bytes = new byte[fis.available()];
        fis.read(bytes);
        System.out.println(Arrays.toString(bytes));
    }
}
