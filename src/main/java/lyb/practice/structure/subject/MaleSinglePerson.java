package lyb.practice.structure.subject;

/**
 * 项目名称：pattern
 * 功能说明: 男狗
 * 创建日期：2019/7/26
 *
 * @Author: LYB
 */
public class MaleSinglePerson implements SinglePerson {
    @Override
    public void findLover() {
        System.out.println("找女朋友，越漂亮越好！");
    }

    @Override
    public void getMarried() {
        System.out.println("找到女朋友，结婚了！");
    }
}
