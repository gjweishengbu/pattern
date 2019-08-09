package lyb.practice.structure.adapter.login.versionOLd;

import lyb.practice.entity.ResultMsg;

/**
 * 后期拓展三方注册登录功能
 * 三方登录注册变动总体可能性很大，不符合开闭原则
 * 总汇与一个类，不便于工作分派
 * Created by Tom on 2019/3/16.
 */
public class SinginForThirdService extends SiginService {

    public ResultMsg loginForQQ(String openId){
        //1、openId是全局唯一，我们可以把它当做是一个用户名(加长)
        //2、密码默认为QQ_EMPTY
        //3、注册（在原有系统里面创建一个用户）

        //4、调用原来的登录方法

        return loginForRegist(openId,null);
    }

    public ResultMsg loginForWechat(String openId){
        return null;
    }

    public ResultMsg loginForToken(String token){
        //通过token拿到用户信息，然后再重新登陆了一次
        return  null;
    }

    public ResultMsg loginForTelphone(String telphone,String code){

        return null;
    }

    public ResultMsg loginForRegist(String username,String password){
        super.regist(username,null);
        return super.login(username,null);
    }
}
