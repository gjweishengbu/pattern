package lyb.practice.behavioral.delegate;

/**
 * 项目名称：pattern
 * 功能说明: 被委派者，编码工作
 * 创建日期：2019/8/5
 *
 * @Author: LYB
 */
public class TargetCoding implements ITarget{
    @Override
    public void doJob(String order) {
        System.out.println(order+"命令。"+this.getClass().getSimpleName()+"执行coding工作！");

    }
}
