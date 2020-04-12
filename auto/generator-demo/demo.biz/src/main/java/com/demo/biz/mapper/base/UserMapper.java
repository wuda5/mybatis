package com.demo.biz.mapper.base;

import com.demo.biz.entity.base.User;
import com.demo.biz.entity.base.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    /** 1.重要：动态自己组装添加 条件 -->查询：*/
    List<User> selectByExample(UserExample example);
    /** 2.重要：自己组装条件删除 */
    int deleteByExample(UserExample example);

    /** 3.重要：更新 **/
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);



    User selectByPrimaryKey(Integer id);

    /**删除 */
    long countByExample(UserExample example);


    int deleteByPrimaryKey(Integer id);

   /** add **/
    int insert(User record);

    int insertSelective(User record);


    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}