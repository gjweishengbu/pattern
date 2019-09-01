package lyb.practice.behavioral.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * 项目名称：pattern
 * 功能说明: 社区老师，观察者
 * JDK方式，需实现Oberver
 * 创建日期：2019/8/19
 *
 * @Author: LYB
 */
public class Teacher implements Observer {

    private String name ;

    public Teacher(String name) {
        this.name = name;
    }

    /**
     * 观察者，收到触发时的回调方法
     *
     * @param o   被观察对象
     * @param arg 触发时传入的参数
     */
    @Override
    public void update(Observable o, Object arg) {
        Gper gper = (Gper) o;
        Question question = (Question) arg;
        System.out.println(this.getName() +"老师！您好！ \n"+
            question.getAsker() + "在"+ ((Gper) o).getName()+"咨询问题:\n"+
            question.getContent());

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
