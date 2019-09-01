package lyb.practice.behavioral.observer.jdk;

import java.util.Observable;

/**
 * 项目名称：pattern
 * 功能说明: 咕泡社区，一个可被监控的场景
 *           JDK 方式实现 需继承Observable
 * 创建日期：2019/8/19
 *
 * @Author: LYB
 */
public class Gper extends Observable {
    // 场景名称
    private String name ="GP社区";

    // 懒汉单例
    private static Gper gper;

    private Gper(){
        
    }

    public static Gper getInstance() {
        if (gper == null) {
            synchronized (Gper.class) {
                if (gper == null) {
                    gper = new Gper();
                }
            }
        }

        return gper;
    }

    /**
     * 发布问题
     */
    public void deleveQuestion(Teacher teacher,Question question){
        this.addObserver(teacher);
        // 设置更新
        setChanged();
        // 通知观察者,触发，需转发的参数带上
        notifyObservers(question);

    }

    public String getName() {
        return name;
    }
}
