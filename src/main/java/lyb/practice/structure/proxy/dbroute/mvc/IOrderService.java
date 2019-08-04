package lyb.practice.structure.proxy.dbroute.mvc;

import lyb.practice.structure.proxy.dbroute.entity.Order;

/**
 * 项目名称：pattern
 * 功能说明: service接口
 * 创建日期：2019/8/3
 *
 * @Author: LYB
 */
public interface IOrderService {
    int createOrder(Order order);
}
