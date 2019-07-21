package lyb.practice.creational.singleton.register;

/**
 * 项目名称：pattern
 * 功能说明: Enum 单例
 * 枚举式单例利用的枚举天生的防反射和反序列换破坏，是超级大拿推荐的方式
 * 创建日期：2019/7/21
 *
 * @Author: LYB
 */
public enum EnumSingleton {
    INSTANCE;

   /* // 显式构造构造器无用，class中 完全忽略
    编译后只会有下列构造器，且无法显示写出
    private EnumSingleton(String s, int i)
    {
        super(s, i);
    }*/
    EnumSingleton(){}

    private EnumSingleton(String s, int i)
    {
    }


    /**
     * 扩展实用属性
     */
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }

}
