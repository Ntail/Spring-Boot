package cn.timebusker.dao;

import cn.timebusker.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.eclipse.jetty.server.Authentication;

import java.util.List;
import java.util.Map;

/**
 * 基于注解实现持久化操作
 */
@Mapper
public interface UserInfoMapper {

    @Select("SELECT * FROM user_info WHERE username = #{name}")
    List<UserInfo> findByName(@Param("name") String name);

    @Select("SELECT * FROM user_info WHERE id = #{id}")
    List<UserInfo> findById(@Param("id") int id);

    // @Insert("INSERT INTO user_info(Id,username,password,usertype,enabled,realname,email,tel) VALUES(#{id,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR},#{password,jdbcType=VARCHAR}, #{usertype,jdbcType=VARCHAR},#{enabled,jdbcType=INTEGER}, #{realname,jdbcType=VARCHAR},#{email,jdbcType=VARCHAR}, #{tel,jdbcType=VARCHAR})")
    @Insert("INSERT INTO user_info(Id,username,password,usertype,enabled,realname,email,tel) VALUES(#{id}, #{username},#{password}, #{usertype},#{enabled}, #{realname},#{email}, #{tel})")
    int insertByMap(Map<String,Object> map);

    @Select("SELECT *　FROM")
    List<UserInfo> findAll();
}
