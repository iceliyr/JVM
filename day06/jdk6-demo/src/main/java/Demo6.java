public class Demo6 {
    public static void main(String[] args) {
        int i = 0;
        while (true) {
            String.valueOf(i++).intern();
        }
    }
}