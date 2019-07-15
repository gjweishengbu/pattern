package lyb.practice.creational.abstractFacctory;

import lyb.practice.creational.Food;
import lyb.practice.creational.Tool;

/**
 * 项目名称：pattern
 * 功能说明: :超级工厂规范
 * 创建日期：2019/7/14
 *
 * @author: LYB
 */
public interface ISuperFactory {

    /**
     * 生产一个食物
     * @return
     */
    Food createFood();

    /**
     * 食物使用工具
     * @return
     */
    Tool createTool();


}
