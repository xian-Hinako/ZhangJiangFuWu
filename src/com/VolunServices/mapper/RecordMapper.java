package com.VolunServices.mapper;

import com.VolunServices.pojo.Record;
import com.VolunServices.pojo.RecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecordMapper {
    int countByExample(RecordExample example);

    int deleteByExample(RecordExample example);

    int deleteByPrimaryKey(Integer reacordid);

    int insert(Record record);

    int insertSelective(Record record);

    List<Record> selectByExample(RecordExample example);

    Record selectByPrimaryKey(Integer reacordid);

    int updateByExampleSelective(@Param("record") Record record, @Param("example") RecordExample example);

    int updateByExample(@Param("record") Record record, @Param("example") RecordExample example);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);
    
    List<Record> selectAllRec();
    
    List<Record> selectByActId(int actid);
    
    List<Record> selectByUsId(int usid);
    
    List<Record> selectDua(float sum);
    
    Float countDuration(int uid);
    
    int updateActInfoByActId(int actid);
    
    int deleteSelectRecord(String _parameter);
    
    Float totaltime(int uid);
    
    List<Record> selRecordByuidFour(int uid);
}