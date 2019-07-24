package lyb.practice.creational.prototype.deep;

import java.io.Serializable;

/**
 * 项目名称：pattern
 * 功能说明: 孙悟空胡毫毛
 * 创建日期：2019/7/23
 *
 * @Author: LYB
 */
public class Haomao implements Serializable {
    private float length = 1L;

    public  Haomao(float length){
        this.length= length;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }
}
