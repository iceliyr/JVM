package chapter03.stringtable;

import java.util.Scanner;

/**
 * intern案例
 */
public class InternDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.next();
        String input2 = scanner.next();

        System.out.println(input1 == input2);
    }
}
