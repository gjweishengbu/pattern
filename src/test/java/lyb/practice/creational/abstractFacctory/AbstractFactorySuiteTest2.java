package lyb.practice.creational.abstractFacctory;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * 项目名称：pattern
 * 功能说明: :重复Suite 测试
 * 创建日期：2019/7/14
 *
 * @author: LYB
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
    StandardSuperFactoeyTest.class,
    ChineseFactoryTest.class,
    ForeignFactoryTest.class
})
public class AbstractFactorySuiteTest2 {
}
