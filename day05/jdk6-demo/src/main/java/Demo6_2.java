import java.util.ArrayList;
import java.util.List;

public class Demo6_2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        int i = 0;
        while (true) {
            //String.valueOf(i++).intern(); //JDK1.6 perm gen 不会溢出
            list.add(String.valueOf(i++).intern()); //溢出
        }
    }
}
