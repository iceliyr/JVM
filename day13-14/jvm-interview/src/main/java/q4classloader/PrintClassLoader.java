package q4classloader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class PrintClassLoader {
    public static void main(String[] args) throws ScriptException {
        //String类 核心类 由启动类加载器加载，在Java中无法获得启动类加载器
        System.out.println(java.lang.String.class.getClassLoader());


        //nashorn包中的类，使用java script引擎打印Hello World 由扩展类加载器加载
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval("print('Hello World!');");
        System.out.println(ScriptEngineManager.class.getClassLoader());


        //项目中classpath下的类，由应用程序类加载器加载
        System.out.println(PrintClassLoader.class.getClassLoader());
    }
}
