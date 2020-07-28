package com.VolunServices.mapper;

import com.VolunServices.pojo.Unpart;
import com.VolunServices.pojo.UnpartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UnpartMapper {
    int countByExample(UnpartExample example);

    int deleteByExample(UnpartExample example);

    int deleteByPrimaryKey(Integer unpartid);

    int insert(Unpart record);

    int insertSelective(Unpart record);

    List<Unpart> selectByExample(UnpartExample example);

    Unpart selectByPrimaryKey(Integer unpartid);

    int updateByExampleSelective(@Param("record") Unpart record, @Param("example") UnpartExample example);

    int updateByExample(@Param("record") Unpart record, @Param("example") UnpartExample example);

    int updateByPrimaryKeySelective(Unpart record);

    @Transactional
    int updateByPrimaryKey(Unpart record);
    
    List<Unpart> selectAllUnpa();
    
    List<Unpart> selectbyActId(int upId);
    
    int deleteByActId(int actId);
    
    int selectByUidAndActId(Unpart un);
    
    int countUnpartIdByActId(int actId);
    
    int deleteSelectUnpart(String _parameter);
    
    List<Unpart> FindUnpartByUid(int uid);
    
    List<Unpart> selUnpartByuidPreTwo(int uid);
}