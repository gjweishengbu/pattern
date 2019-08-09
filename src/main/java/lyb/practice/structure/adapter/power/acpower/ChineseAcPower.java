package lyb.practice.structure.adapter.power.acpower;

/**
 * 项目名称：pattern
 * 功能说明: 中国通用交流电
 * 创建日期：2019/8/9
 *
 * @Author: LYB
 */
public class ChineseAcPower implements AcPower {
    public final static int outV = 220;

    @Override
    public int outPutV() {
        return outV;
    }
}
