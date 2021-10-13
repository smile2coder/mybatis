package com.smile2coder;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AccountMapper {

    @Select("select * from account")
    List<Account> list();

    @Select("select * from account where id = #{id}")
    Account getById(Long id);

    @Update("update account set name = #{name} where id = #{id}")
    int updateById(@Param("name") String name, @Param("id") Long id);
}
