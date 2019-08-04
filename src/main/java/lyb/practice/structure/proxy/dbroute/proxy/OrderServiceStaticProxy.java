package lyb.practice.structure.proxy.dbroute.proxy;

import lyb.practice.structure.proxy.dbroute.db.DynamicDataSourceEntity;
import lyb.practice.structure.proxy.dbroute.entity.Order;
import lyb.practice.structure.proxy.dbroute.mvc.IOrderService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 项目名称：pattern
 * 功能说明: 订单数据源静态代理
 * 创建日期：2019/8/3
 *
 * @Author: LYB
 */
public class OrderServiceStaticProxy implements IOrderService{
    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

    private IOrderService orderService;
    public OrderServiceStaticProxy(IOrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public int createOrder(Order order) {
        Long time = order.getCreateTime();
        Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(time)));
        System.out.println("静态代理类自动分配到【DB_" +  dbRouter + "】数据源处理数据" );
        DynamicDataSourceEntity.set(dbRouter);

        this.orderService.createOrder(order);
        DynamicDataSourceEntity.reset();

        return 0;
    }

}
