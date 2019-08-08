package lyb.practice.behavioral.template.jdbc;

import java.sql.ResultSet;

/**
 * 项目名称：pattern
 * 功能说明: ORM映射定制化的接口
 * 创建日期：2019/8/8
 *
 * @Author: LYB
 */
public interface RowMapper<T> {
    T mapRow(ResultSet rs, int rowNum) throws  Exception;

}
