package com.VolunServices.mapper;

import com.VolunServices.pojo.Userinfo;
import com.VolunServices.pojo.UserinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserinfoMapper {
    int countByExample(UserinfoExample example);

    int deleteByExample(UserinfoExample example);

    int deleteByPrimaryKey(Integer uiid);
    
    int deleteSelectUserIn(String _parameter);

    int insert1(Userinfo record);

    int insertSelective(Userinfo record);

    List<Userinfo> selectByExampleWithBLOBs(UserinfoExample example);

    List<Userinfo> selectByExample(UserinfoExample example);

    Userinfo selectByPrimaryKey(Integer uiid);

    int updateByExampleSelective(@Param("record") Userinfo record, @Param("example") UserinfoExample example);

    int updateByExampleWithBLOBs(@Param("record") Userinfo record, @Param("example") UserinfoExample example);

    int updateByExample(@Param("record") Userinfo record, @Param("example") UserinfoExample example);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKeyWithBLOBs(Userinfo record);

    int updateByPrimaryKey(Userinfo record);
    
    List<Userinfo> sellectAllUsIn();
    
    List<Userinfo> sellectusInByName(String uIName);
    
    int insertmanager(Userinfo ui);  
    
    int insert(Userinfo record);
    
    //÷ÿ÷√√‹¬Î
    List<Userinfo> loginList(Userinfo userinfo);

}