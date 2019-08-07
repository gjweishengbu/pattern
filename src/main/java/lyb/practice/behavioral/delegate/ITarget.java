package lyb.practice.behavioral.delegate;

/**
 * 项目名称：pattern
 * 功能说明: 被委派者接口
 * 创建日期：2019/8/5
 *
 * @Author: LYB
 */
public interface ITarget {
    /**
     * 被委派 按命令执行特定工作
     * @param order
     */
    void doJob(String order);
}
