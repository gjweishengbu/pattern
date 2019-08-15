package lyb.practice.structure.decorator.battercake.v1;

/**
 * Created by Tom on 2019/3/17.
 * 简单设计，继承方式拓展，不适用说有情况
 */
public class Battercake {

    protected String getMsg(){
        return "煎饼";
    }

    public int getPrice(){
        return 5;
    }

}
