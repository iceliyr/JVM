package chapter03.localvariabletable;

/**
 * 栈帧-局部变量表
 */
public class Demo1 {
    public static void test1(){
        int i = 0;
        long j = 1;
    }

    public void test2(){
        int i = 0;
        long j = 1;
    }

    public void test3(int k,int m){
        int i = 0;
        long j = 1;
    }

    public void test4(int k,int m){
        {
            int a = 1;
            int b = 2;
        }
        {
            int c = 1;
        }
        int i = 0;
        long j = 1;
    }
    
    public void test5(){
        int i = 0;
        int j = i + 1;
    }

    public static void test6()  {
        int i = 0;
        try{
            i = 1;
        }catch (Exception e){
            i = 2;
        }

    }
}
