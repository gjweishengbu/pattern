package lyb.practice.structure.proxy.dbroute.mvc;

import lyb.practice.structure.proxy.dbroute.entity.Order;

/**
 * 项目名称：pattern
 * 功能说明: 订单dao
 * 创建日期：2019/8/3
 *
 * @Author: LYB
 */
public class OrderDao {

    public int insert(Order order){
        System.out.println("dao订单确认成功");
        return 1;
    }

}
