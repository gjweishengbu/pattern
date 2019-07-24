package lyb.practice.creational.prototype.deep;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 项目名称：pattern
 * 功能说明: 深克隆，
 *          实现Serializable 用序列化方式实现深克隆
 *          实现Cloneable 改写原浅克隆方式
 * 创建日期：2019/7/23
 *
 * @Author: LYB
 *
 * 描述是孙悟空拔毫毛变猴子
 */
public class DeeplyPrototype extends Monkey implements Serializable,Cloneable {



    /**
     * 金箍棒
     */
    public JinGuBang jinGuBang;

    /**
     * 毫毛
     */
    private List<Haomao> haomaos= new ArrayList();

    public  DeeplyPrototype(){
        //只是初始化
        this.birthday = new Date();
        this.jinGuBang = new JinGuBang();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return deepclone();
    }

    /**
     * 深克隆
     * @return
     */
    public Object deepclone(){
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            DeeplyPrototype clone = (DeeplyPrototype)ois.readObject();
            clone.birthday = new Date();
            return  clone;

        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }

    }

    /**
     * Object克隆
     * @return
     */
    public Object superficialClone() throws Exception{
        return super.clone();
    }

    public JinGuBang getJinGuBang() {
        return jinGuBang;
    }

    public void setJinGuBang(JinGuBang jinGuBang) {
        this.jinGuBang = jinGuBang;
    }

    public List<Haomao> getHaomaos() {
        return haomaos;
    }

    public void setHaomaos(List<Haomao> haomaos) {
        this.haomaos = haomaos;
    }
}
