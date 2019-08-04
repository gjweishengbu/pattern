package lyb.practice.structure.subject;

/**
 * 项目名称：pattern
 * 功能说明: 无接口普通类,演示CGLibdaif代理
 *           final 类不能被代理，会抛异常
 *           final 方法不能被增强
 * 创建日期：2019/7/26
 *
 * @Author: LYB
 */

//java.lang.IllegalArgumentException: Cannot subclass final class lyb.practice.structure.subject.NormalSinglePerson
//public final class NormalSinglePerson {
public class NormalSinglePerson {
    public void findLover() {
        System.out.println("找男朋友，越帅越好！");
    }

    public void getMarried() {
        System.out.println("找到女朋友，结婚了！");
    }

    public final void getMarriedFinal() {
        System.out.println("找到女朋友，结婚了！");
    }
}
