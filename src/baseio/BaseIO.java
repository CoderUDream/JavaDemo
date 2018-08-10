package baseio;

import java.io.*;
import java.util.Arrays;

public class BaseIO {

    //通过fileReader 字符读取
    public static void fileReader() {
        try
        {
            //按照字符读取
            FileReader fr = new FileReader("resources/english.txt");
            BufferedReader br = new BufferedReader(fr);
            StringBuffer sb = new StringBuffer();
            String s;
            while((s = br.readLine()) != null) {
                sb.append(s).append("\n");
                System.out.println(s);
            }
            fr.close();
            System.out.println(sb.toString());

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    //通过 fileInputStream 字节读取
    public static void fileInputStream() {
        try {
            FileInputStream in = new FileInputStream("resources/chinease.txt");

            StringBuffer sb = new StringBuffer();
            int length;
            byte[] buf = new byte[50];

            while((length = in.read(buf)) != -1) {
                //出现编码问题，在转string的时候  将其转换成对应的编码
                sb.append(new String(buf, 0, length, "GB2312"));
            }
            System.out.println(sb.toString());
            in.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    //通过 fileOutputStream 字节写
    public static void fileOutputStream() {
        try
        {
            FileOutputStream fout = new FileOutputStream(new File("resources/fileout.txt"));
            fout.write(new String("hello jiang 我很好").getBytes());
            fout.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }
}