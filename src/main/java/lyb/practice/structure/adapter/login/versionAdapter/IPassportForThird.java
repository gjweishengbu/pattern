package lyb.practice.structure.adapter.login.versionAdapter;

import lyb.practice.entity.ResultMsg;

/**
 * 项目名称：pattern
 * 功能说明: 只扩展，新增三方
 * 创建日期：2019/8/9
 *
 * @Author: LYB
 */
public interface IPassportForThird {
    /**
     * QQ登录
     * @param id
     * @return
     */
    ResultMsg loginForQQ(String id);

    /**
     * 微信登录
     * @param id
     * @return
     */
    ResultMsg loginForWechat(String id);

    /**
     * 记住登录状态后自动登录
     * @param token
     * @return
     */
    ResultMsg loginForToken(String token);

    /**
     * 手机号登录
     * @param telphone
     * @param code
     * @return
     */
    ResultMsg loginForTelphone(String telphone, String code);

    /**
     * 注册后自动登录
     * @param username
     * @param passport
     * @return
     */
    ResultMsg loginForRegist(String username, String passport);
}
