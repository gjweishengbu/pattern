package lyb.practice.structure.proxy.dbroute.db;

/**
 * 项目名称：pattern
 * 功能说明: 动态数据源
 * 创建日期：2019/8/3
 *
 * @Author: LYB
 */
public class DynamicDataSourceEntity {

    public final static String DEFAULT_SOURCE = null;

    private final  static ThreadLocal<String> local = new ThreadLocal<>();

    private DynamicDataSourceEntity(){}

    public  static String get(){
        return local.get();
    }

    public static void set(String source){
        local.set(source);
    }

    public static void set(int year){
        local.set("DB_"+year);
    }

    public static void reset(){
        local.set(DEFAULT_SOURCE);
    }

}
