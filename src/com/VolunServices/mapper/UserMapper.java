package com.VolunServices.mapper;

import com.VolunServices.pojo.User;
import com.VolunServices.pojo.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    int updateByUname(User record);//重置密码
    
    User loginByname(User u);
    
    List<User> selectAll();
    
  //  int updatePassByKey(User u);
    
    User selectByName(String name);
    
    int countselectByName(String name); 
    
    int selectByNameReId(String name);
    
    List<User> selectIdentity(int identity);
    
    List<User> loginList(String uname, String phone);
    
    int ManagerPass(User user);
    
    //检查输入的旧密码是否正确
    String checkoldPassword(int uid);
}