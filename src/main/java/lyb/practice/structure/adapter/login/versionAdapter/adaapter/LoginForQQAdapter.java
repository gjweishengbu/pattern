package lyb.practice.structure.adapter.login.versionAdapter.adaapter;

import lyb.practice.entity.ResultMsg;

/**
 * Created by Tom on 2019/3/16.
 */
public class LoginForQQAdapter implements LoginAdapter {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForQQAdapter;
    }
    @Override
    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}
