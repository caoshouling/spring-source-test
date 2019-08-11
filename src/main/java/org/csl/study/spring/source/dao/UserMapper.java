package org.csl.study.spring.source.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.session.RowBounds;
import org.csl.study.spring.source.dao.provider.UserSqlProvider;
import org.csl.study.spring.source.po.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    @SelectProvider(type = UserSqlProvider.class, method = "selectUserByUserNameAndPassword")
    @Results({
		@Result(column="user_name",property="userName")
    })
    User selectUserByUserNameAndPassword(@Param("userName")String userName,@Param("password") String password);
    
    @Select("select * from sys_user where user_name = #{userName}")
    @Results({
		@Result(column="user_name",property="userName")
    })
    User selectUserByUserName(@Param("userName")String userName);
    
    @Select("select * from sys_user order by id")
    @Results({
		@Result(column="user_name",property="userName")
    })
    List<User> findAllWithRowBounds(RowBounds rowBounds);

    @Select("select * from sys_user order by id")
    @Results({
		@Result(column="user_name",property="userName")
    })
    List<User> findAllWithParam(@Param("pageNum") int pageNum,
                                  @Param("pageSize") int pageSize);
}