package lyb.practice.behavioral.observer.events.core;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * 项目名称：pattern
 * 功能说明: 观察值事件
 * 创建日期：2019/8/26
 *
 * @Author: LYB
 */
public class Event {
    /**
     * 事件源，发起者
     */
    private Object source;
    /**
     * 通知目标 观察者
     */
    private Object target;
    /**
     * 事件触发回调
     */
    private Method callback;
    /**
     * 触发事件
     */
    private Object trigger;
    /**
     * 触发始建
     */
    private Date time;

    public Event(Object target, Method callback) {
        this.target = target;
        this.callback = callback;
    }

    public Object getSource() {
        return source;
    }

    public Event setSource(Object source) {
        this.source = source;
        return this;
    }

    public Object getTarget() {
        return target;
    }

    public Event setTarget(Object target) {
        this.target = target;
        return this;
    }

    public Object getCallback() {
        return callback;
    }

    public Event setCallback(Method callback) {
        this.callback = callback;
        return this;
    }

    public Object getTrigger() {
        return trigger;
    }

    public void setTrigger(Object trigger) {
        this.trigger = trigger;
    }

    public Object getTime() {
        return time;
    }

    public Event setTime(Date time) {
        this.time = time;
        return this;
    }

    @Override
    public String toString() {
        return "Event{" + "\n" +
            "\tsource=" + source.getClass() + ",\n" +
            "\ttarget=" + target.getClass() + ",\n" +
            "\tcallback=" + callback + ",\n" +
            "\ttrigger='" + trigger + "',\n" +
            "\ttime=" + time + "'\n" +
            '}';
    }
}
