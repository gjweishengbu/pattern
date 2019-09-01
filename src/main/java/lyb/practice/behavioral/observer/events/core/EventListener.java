package lyb.practice.behavioral.observer.events.core;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 项目名称：pattern
 * 功能说明: 监听器基类 防JDK
 *           实现基本观察者逻辑
 * 创建日期：2019/8/26
 *
 * @Author: LYB
 */
public class EventListener {

    // 核心 一个将所有被观察的事件保存在一起
    protected Map<String,Event> eventsListening = new ConcurrentHashMap<>();

}
