package lyb.practice.creational.singleton;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * 项目名称：pattern
 * 功能说明: 重复测试
 * 创建日期：2019/7/17
 *
 * @Author: LYB
 */
@RunWith(Parameterized.class)
public class RunTenTimes {

    @Parameterized.Parameters
    public static Collection data() {
         return Arrays.asList(new Object[10][0]);
    }

    @Test
    public void runsTenTimes() {
        System.out.println("run");
    }
}

