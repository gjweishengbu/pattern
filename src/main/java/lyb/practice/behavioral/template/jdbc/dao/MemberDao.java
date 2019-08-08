package lyb.practice.behavioral.template.jdbc.dao;

import lyb.practice.behavioral.template.jdbc.JdbcTemplate;
import lyb.practice.behavioral.template.jdbc.RowMapper;
import lyb.practice.behavioral.template.jdbc.entity.Member;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

/**
 * 项目名称：pattern
 * 功能说明: 继承JDBC模版实现Member查询
 * 创建日期：2019/8/8
 *
 * @Author: LYB
 */
public class MemberDao extends JdbcTemplate {
    public MemberDao(DataSource dataSource) {
        super(dataSource);
    }

    public List<?> selectAll(){
        String sql = "select * from t_member";
        return super.executeQuery(sql, new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet rs, int rowNum) throws Exception {
                Member member = new Member();
                //字段过多，原型模式
                member.setUsername(rs.getString("username"));
                member.setPassword(rs.getString("password"));
                member.setAge(rs.getInt("age"));
                member.setAddr(rs.getString("addr"));
                return member;
            }
        },null);


    }


}
