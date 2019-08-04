package lyb.practice.structure.proxy.dbroute.entity;

/**
 * 项目名称：pattern
 * 功能说明: 订单
 * 创建日期：2019/8/3
 *
 * @Author: LYB
 */
public class Order {

    private Object info;

    // 按订单时间分库
    private Long createTime;

    private String id ;

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
