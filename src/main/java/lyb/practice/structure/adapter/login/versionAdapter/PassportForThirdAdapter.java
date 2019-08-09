package lyb.practice.structure.adapter.login.versionAdapter;

import lyb.practice.structure.adapter.login.versionAdapter.adaapter.LoginAdapter;
import lyb.practice.structure.adapter.login.versionAdapter.adaapter.LoginForQQAdapter;
import lyb.practice.structure.adapter.login.versionAdapter.adaapter.LoginForWechatAdapter;
import lyb.practice.structure.adapter.login.versionOLd.SiginService;
import lyb.practice.entity.ResultMsg;

/**
 * 项目名称：pattern
 * 功能说明: 三方登录适配器
 *          结合策略，工厂，适配器
 *
 *          继承原生登录注册类，实现三方接口
 * 创建日期：2019/8/9
 *
 * @Author: LYB
 */
public class PassportForThirdAdapter extends SiginService implements IPassportForThird{
    /**
     * 使用相应的三方适配器登录 策略模式实现选择调用
     * @param key
     * @param adapterCLazz
     * @return
     */
    private ResultMsg processLogin(String key, Class<? extends LoginAdapter> adapterCLazz) {
        try {
            // 适配器不一定需要实现接口
            LoginAdapter loginAdapter = adapterCLazz.newInstance();

            if (loginAdapter.support(loginAdapter)){
                return loginAdapter.login(key,loginAdapter);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public ResultMsg loginForQQ(String id) {
        return processLogin(id, LoginForQQAdapter.class);
    }



    @Override
    public ResultMsg loginForWechat(String id) {
        return processLogin(id, LoginForWechatAdapter.class);
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return processLogin(token, LoginForWechatAdapter.class);
    }

    @Override
    public ResultMsg loginForTelphone(String telphone, String code) {
        return processLogin(telphone, LoginForWechatAdapter.class);
    }

    @Override
    public ResultMsg loginForRegist(String username, String passport) {
        super.regist(username,passport);
        return super.login(username,passport);
    }
}
