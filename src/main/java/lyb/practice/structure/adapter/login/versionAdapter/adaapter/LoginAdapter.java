package lyb.practice.structure.adapter.login.versionAdapter.adaapter;

import lyb.practice.entity.ResultMsg;

/**
 * 项目名称：pattern
 * 功能说明: 登录适配器
 * 创建日期：2019/8/9
 *
 * @Author: LYB
 */
public interface LoginAdapter {
    /**
     * 检查是否兼容
     *
     * @param adapter
     * @return
     */
    boolean support(Object adapter);

    /**
     * 三方登录
     *
     * @param id
     * @param adapter
     * @return
     */
    ResultMsg login(String id, Object adapter);

}
