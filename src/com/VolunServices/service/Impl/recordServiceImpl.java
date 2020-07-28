package com.VolunServices.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VolunServices.mapper.RecordMapper;
import com.VolunServices.pojo.Record;
import com.VolunServices.service.recordService;

@Service
public class recordServiceImpl implements recordService{

	@Autowired
	private RecordMapper recomapper;

	public List<Record> AllRecord() {
		List<Record> AllRec = recomapper.selectAllRec();
		return AllRec;
	}

	@Override
	public List<Record> SelByUsId(int uid) {
		List<Record> selReByUsId = recomapper.selectByUsId(uid);
		return selReByUsId;
	}

	@Override
	public List<Record> SelByActId(int actid) {
		List<Record> selReByActId = recomapper.selectByActId(actid);
		return selReByActId;
	}

	//���Ҵ���ĳ��ʱ���ļ�¼
	public List<Record> SelByDura(float sum) {
		List<Record> selRetDua = recomapper.selectDua(sum);
		return selRetDua;
	}

	@Override
	public int AddRecord(Record re) {
		int flag = recomapper.insert(re);
		return flag;
	}

	@Override
	public int UpdateRecord(Record re) {
		int flag = recomapper.updateByPrimaryKey(re);
		return flag;
	}

	@Override
	public int DeleteRecord(int reId) {
		int flag = recomapper.deleteByPrimaryKey(reId);
		return flag;
	}

	//ͳ��ÿ���û�ʱ��
	public Float CountDuration(int uid) {
		float sum = recomapper.countDuration(uid);
		return sum;
	}

	@Override
	public int UpdateByActId(int actId) {
		int flag = recomapper.updateActInfoByActId(actId);
		return flag;
	}

	//����ɾ��
	public boolean DeleteSelectRecordS(String _parameter) {
		boolean flag = false;
		int fla = recomapper.deleteSelectRecord(_parameter);
		if(fla == 1){
			flag = true;
		}
		return flag;
	}

	//������������
	public Record selByParyKey(int recordid) {
		Record selectByPrimaryKey = recomapper.selectByPrimaryKey(recordid);
		return selectByPrimaryKey;
	}

	//��������ܷ���ʱ��
	public Float totaltimeS(int uid) {	
		return recomapper.totaltime(uid);
	}

	//���˼�¼��ǰ4��
	public List<Record> FindPreFour(int uid) {
		List<Record> selRecordByuidFour = recomapper.selRecordByuidFour(uid);
		return selRecordByuidFour;
	}

}
