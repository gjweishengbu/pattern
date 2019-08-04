package lyb.practice.structure.subject;

/**
 * 项目名称：pattern
 * 功能说明: 女狗
 * 创建日期：2019/7/26
 *
 * @Author: LYB
 */
public class FemaleSinglePerson implements SinglePerson {
    @Override
    public void findLover() {
        System.out.println("找男朋友，越帅越好！");
    }

    @Override
    public void getMarried() {
        System.out.println("找到男朋友，结婚了！");
    }
}
