package lyb.practice.structure.adapter.power.dcpower;

import lyb.practice.structure.adapter.power.acpower.AcPower;
import lyb.practice.structure.adapter.power.acpower.ChineseAcPower;

/**
 * 项目名称：pattern
 * 功能说明: 中国适用转换器
 * 创建日期：2019/8/9
 *
 * @Author: LYB
 */
public class ChineseDcAdapter implements DcAdaper {
    AcPower acPower;

    public ChineseDcAdapter(AcPower acPower) {
        this.acPower = acPower;
    }

    @Override
    public boolean support() {
        return acPower instanceof  AcPower && acPower.outPutV() == ChineseAcPower.outV;
    }

    @Override
    public int outPutV() {
        return support() ? acPower.outPutV() / 22 : 0;
    }
}
