package lyb.practice.structure.proxy.dynamic.jdkproxy.myjdk;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 项目名称：pattern
 * 功能说明: 仿造JDK动态代理
 * 主要构建代理类源码、编译，加载工作
 * 创建日期：2019/7/29
 *
 * @Author: LYB
 */
public class MyProxy implements Serializable {
    private static final String ln = "\r\n";

    /**
     * the invocation handler for this proxy instance.
     * @serial
     */
    protected MyInvocationHandler h;

    private static Map<Class,Class> mappings = new HashMap<Class, Class>();
    static {
        mappings.put(int.class,Integer.class);
    }


    protected MyProxy(MyInvocationHandler h) {
        Objects.requireNonNull(h);
        this.h = h;
    }

    public static Object newProxyInstance(MyClassLoader loader,
                                          Class<?>[] interfaces,
                                          MyInvocationHandler h) {
        try {
            // 构建源码
            String src = generateSrc(interfaces);

            // java 文件输出磁盘
            String filePath = MyProxy.class.getResource("").getPath();
            File f = new File(filePath + "$MyProxy0.java");
            FileWriter fw = new FileWriter(f);
            fw.write(src);
            fw.flush();
            fw.close();

            //3、把生成的.java文件编译成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manage = compiler.getStandardFileManager(null,null,null);
            Iterable iterable = manage.getJavaFileObjects(f);
            JavaCompiler.CompilationTask task = compiler.getTask(null,manage,null,null,null,iterable);
            task.call();
            manage.close();

            //4、编译生成的.class文件加载到JVM中来
            Class proxyClass =  loader.findClass("$MyProxy0");
            Constructor c = proxyClass.getConstructor(MyInvocationHandler.class);
            f.delete();

            //5、返回字节码重组以后的新的代理对象
            return c.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // todo
        return null;
    }

    /**
     * 根据接口数创建源码
     *
     * @param interfaces
     * @return
     */
    private static String generateSrc(Class<?>[] interfaces) {
        StringBuilder sb = new StringBuilder();

        sb.append(MyProxy.class.getPackage()+";"+ln);

        sb.append("import java.lang.reflect.*;"+ln);
        // 多接口要循环，要检查接口数量不能超过65535
        sb.append("import "+interfaces[0].getName() +";"+ln);
        sb.append("public final class $MyProxy0 extends MyProxy"+ln);
        sb.append("    implements ").append(interfaces[0].getSimpleName()+ln);
        sb.append("{"+ln);

        sb.append("    public $MyProxy0(MyInvocationHandler myInvocationhandler)"+ln);
        sb.append("    {"+ln);
        sb.append("        super(myInvocationhandler);"+ln);
        sb.append("    }"+ln);

        // 接口中的方法
        for (Method m : interfaces[0].getMethods()) {
            Class<?>[] params = m.getParameterTypes();

            StringBuffer paramNames = new StringBuffer();
            StringBuffer paramValues = new StringBuffer();
            StringBuffer paramClasses = new StringBuffer();

            for (int i = 0; i < params.length; i++) {
                Class clazz = params[i];
                String type = clazz.getName();
                String paramName = toLowerFirstCase(clazz.getSimpleName());
                paramNames.append(type + " " + paramName);
                paramValues.append(paramName);
                paramClasses.append(clazz.getName() + ".class");
                if (i > 0 && i < params.length - 1) {
                    paramNames.append(",");
                    paramClasses.append(",");
                    paramValues.append(",");
                }
            }

            sb.append("     @Override"+ln);
            // 方法访问限制，需要翻译
//            sb.append("    "+m.getModifiers()+" final "+m.getReturnType().getName()+" "+m.getName()+"("+ paramNames.toString()+")"+ln);
            sb.append("    public final "+m.getReturnType().getName()+" "+m.getName()+"("+ paramNames.toString()+")"+ln);
            sb.append("    {"+ln);
            sb.append("        try"+ln);
            sb.append("        {"+ln);
            sb.append("        Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() + "\",new Class[]{" + paramClasses.toString() + "});" + ln);
            sb.append("            super.h.myInvoke(this, m, new Object[]{" + paramValues + "});"+ln);
            sb.append((hasReturnValue(m.getReturnType()) ? "return " : "") + getCaseCode("super.h.myInvoke(this,m,new Object[]{" + paramValues + "})",m.getReturnType()) + ";" + ln);
            sb.append("        }"+ln);
            sb.append("        catch(Error _ex) { }"+ln);
            sb.append("        catch(Throwable throwable)"+ln);
            sb.append("        {"+ln);
//            sb.append("            throw new UndeclaredThrowableException(throwable);"+ln);
            sb.append("          throwable.printStackTrace();" + ln);
            sb.append("        }"+ln);
            sb.append(getReturnEmptyCode(m.getReturnType())+ln);
            sb.append("    }"+ln);



        }
        // JDK 方式，实现比较麻烦
       /* sb.append("    private static Method m3;"+ln);

        sb.append("    static"+ln);
        sb.append("    {"+ln);
        sb.append("        try"+ln);
        sb.append("        {"+ln);
        sb.append("            m3 = Class.forName(\"lyb.practice.structure.subject.SinglePerson\").getMethod(\"findLover\", new Class[0]);"+ln);
        sb.append("        }"+ln);
        sb.append("        catch(NoSuchMethodException nosuchmethodexception)"+ln);
        sb.append("        {"+ln);
        sb.append("            throw new NoSuchMethodError(nosuchmethodexception.getMessage());"+ln);
        sb.append("        }"+ln);
        sb.append("        catch(ClassNotFoundException classnotfoundexception)"+ln);
        sb.append("        {"+ln);
        sb.append("            throw new NoClassDefFoundError(classnotfoundexception.getMessage());"+ln);
        sb.append("        }"+ln);
        sb.append("    }"+ln);*/

        sb.append("}"+ln);
//        System.out.println(sb.toString());

        return sb.toString();

    }

    private static String toLowerFirstCase(String src){
        char [] chars = src.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

    private static boolean hasReturnValue(Class<?> clazz){
        return clazz != void.class;
    }

    private static String getCaseCode(String code,Class<?> returnClass){
        if(mappings.containsKey(returnClass)){
            return "((" + mappings.get(returnClass).getName() +  ")" + code + ")." + returnClass.getSimpleName() + "Value()";
        }
        return code;
    }

    private static String getReturnEmptyCode(Class<?> returnClass){
        if(mappings.containsKey(returnClass)){
            return "return 0;";
        }else if(returnClass == void.class){
            return "";
        }else {
            return "return null;";
        }
    }

}
