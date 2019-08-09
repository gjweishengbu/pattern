package lyb.practice.structure.adapter.power.dcpower;

/**
 * 项目名称：pattern
 * 功能说明: 家用直流电的普及需要适配各种转换器
 * 创建日期：2019/8/9
 *
 * @Author: LYB
 */
public interface DcAdaper {
    /**
     * 检查是否支持
     * @return
     */
    boolean support();

    /**
     * 提供输出
     * @return
     */
    int outPutV();

}
