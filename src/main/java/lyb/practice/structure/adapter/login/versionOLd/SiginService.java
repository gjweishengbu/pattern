package lyb.practice.structure.adapter.login.versionOLd;

import lyb.practice.entity.Member;
import lyb.practice.entity.ResultMsg;

/**
 * 最原始版本
 * 提供本系统原生注册登录功能
 * Created by Tom.
 */
public class SiginService {

    /**
     * 注册方法
     * @param username
     * @param password
     * @return
     */
    public ResultMsg regist(String username, String password){
        return  new ResultMsg(200,"注册成功",new Member());
    }


    /**
     * 登录的方法
     * @param username
     * @param password
     * @return
     */
    public ResultMsg login(String username,String password){
        System.out.println("登录成功！");
        return null;
    }

}
