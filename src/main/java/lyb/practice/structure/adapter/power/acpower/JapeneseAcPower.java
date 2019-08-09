package lyb.practice.structure.adapter.power.acpower;

/**
 * 项目名称：pattern
 * 功能说明: 日本通用交流电
 * 创建日期：2019/8/9
 *
 * @Author: LYB
 */
public class JapeneseAcPower implements AcPower {
    public static final int outV = 110;

    @Override
    public int outPutV() {
        return outV;
    }
}
