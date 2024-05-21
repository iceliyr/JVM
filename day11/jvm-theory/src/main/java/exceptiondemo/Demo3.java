package exceptiondemo;

import org.apache.commons.io.IOUtils;

import java.io.FileWriter;
import java.io.IOException;

public class Demo3 {
    public static void main(String[] args) {
        int i = 0;
        try{
            IOUtils.write("123",
                    new FileWriter("D:\\1.txt"));
        } catch (RuntimeException | IOException e){
            i = 2;
        }
    }
}
