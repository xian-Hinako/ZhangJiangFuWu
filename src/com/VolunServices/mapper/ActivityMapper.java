package com.VolunServices.mapper;

import com.VolunServices.pojo.Activity;
import com.VolunServices.pojo.ActivityExample;
import com.VolunServices.pojo.Page;
import com.VolunServices.pojo.Page10;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivityMapper {
    int countByExample(ActivityExample example);

    int deleteByExample(ActivityExample example);

    int deleteByPrimaryKey(Integer aid);

    int insert(Activity record);

    int insertSelective(Activity record);

    List<Activity> selectByExample(ActivityExample example);

    Activity selectByPrimaryKey(Integer aid);

    int updateByExampleSelective(@Param("record") Activity record, @Param("example") ActivityExample example);

    int updateByExample(@Param("record") Activity record, @Param("example") ActivityExample example);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);
    
    List<Activity> sellectAll();
    
    List<Activity> sellectByName(String aname);
    
    int deleteSelectActivity(String _parameter);
    
    //查询记录总数
    int selectCount();
    
    //分页查询
    List<Activity> list();
    
    List<Activity> list(Page page);
    
    List<Activity> selectPreNice();
    
}