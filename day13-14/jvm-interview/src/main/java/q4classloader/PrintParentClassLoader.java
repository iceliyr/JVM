package q4classloader;



import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class PrintParentClassLoader {
    public static void main(String[] args) throws ScriptException {
        new ScriptEngineManager();
        //扩展类加载器的父类加载器
        System.out.println(ScriptEngineManager.class.getClassLoader().getParent());
        //应用程序类加载器的父类加载器
        System.out.println(PrintParentClassLoader.class.getClassLoader().getParent());
        //自定义类加载器的父类加载器
        System.out.println(new MyClassLoader().getParent());
    }
}
