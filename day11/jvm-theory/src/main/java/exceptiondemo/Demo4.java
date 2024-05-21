package exceptiondemo;

public class Demo4 {
    public static void main(String[] args) {
        int i = 0;
        try{
            i = 1;
        }catch (Exception e){
            i = 2;
        }finally {
            i = 3;
        }
    }
}
