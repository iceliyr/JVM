package q2class;

public class MyClass extends MyParent implements MyInterface{

    private int i = 0;

    @Override
    public void test() {
        int j = 0;
        j++;
    }

    public static void main(String[] args) {
        new MyClass();
    }
}
