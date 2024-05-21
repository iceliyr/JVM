package exceptiondemo;

import java.io.IOException;

public class Demo2 {
    public static void main(String[] args) {
        int i = 0;
        try{
            i = 1;
        } catch (RuntimeException e){
            i = 2;
        } catch (Exception e){
            i = 3;
        }
    }
}
