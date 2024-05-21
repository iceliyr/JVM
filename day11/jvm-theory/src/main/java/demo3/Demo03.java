package demo3;

public class Demo03 {
    static boolean a;
    public static void main(String[] args) {
        a = true;
        if(a){
            System.out.println("a为true");
        }else{
            System.out.println("a为false");
        }

        if(a == true){
            System.out.println("a为true");
        }else{
            System.out.println("a为false");
        }
    }
}
