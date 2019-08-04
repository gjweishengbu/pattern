package lyb.practice.structure.proxy.dbroute.mvc;

import lyb.practice.structure.proxy.dbroute.entity.Order;

/**
 * 项目名称：pattern
 * 功能说明: 订单服务
 * 创建日期：2019/8/3
 *
 * @Author: LYB
 */
public class OrderService implements IOrderService {
    private OrderDao orderDao;

    public OrderService(){
        //如果使用Spring应该是自动注入的
        //我们为了使用方便，在构造方法中将orderDao直接初始化了
        orderDao = new OrderDao();
    }


    @Override
    public int createOrder(Order order) {
        System.out.println("OrderService调用Dao创建订单");
        return orderDao.insert(order);
    }
}
