package lyb.practice.creational.prototype.deep;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目名称：pattern
 * 功能说明: 猴子父类
 * 创建日期：2019/7/23
 *
 * @Author: LYB
 */
public class Monkey implements Serializable,Cloneable {
    public int height;
    public int weight;
    public Date birthday;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

}
