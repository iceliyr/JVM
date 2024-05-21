package exceptiondemo;

public class Demo1 {
    public static void main(String[] args) {
        int i = 0;
        try{
            i = 1;
        }catch (Exception e){
            i = 2;
        }
    }
}
