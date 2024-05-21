package q3loadclass;

//1.连接的准备阶段value赋初值为0
//2.初始化阶段执行clinit方法中的指令,value赋值为2
//3.如果创建对象，会执行构造init方法，value赋值为3 （类中代码块中的内容被放到了构造方法中）
public class Demo1 {
    public static int value = 1;
    static {
        value = 2;
    }
    {
        value = 3;
    }
    public static void main(String[] args) {
        new Demo1();
        System.out.println(value);
    }
}
