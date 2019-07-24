package lyb.practice.creational.prototype.simple;

import java.util.ArrayList;

/**
 * 项目名称：pattern
 * 功能说明: 深克隆
 * 创建日期：2019/7/22
 *
 * @Author: LYB
 */
public class ConcreteDeeplyPrototype implements Prototype {
    private int age;
    private String name;
    private ArrayList list;

    @Override
    public Prototype clone() {
        ConcreteDeeplyPrototype newInstance = new ConcreteDeeplyPrototype();
        newInstance.setAge(this.getAge());
        newInstance.setName(this.getName());
        newInstance.setList(this.getList());
        return newInstance;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList getList() {
        return list;
    }

    public void setList(ArrayList list) {
        this.list = list;
    }
}
