package com.VolunServices.tools;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.VolunServices.pojo.Activity;
import com.VolunServices.pojo.Record;
import com.VolunServices.pojo.Userinfo;
import com.VolunServices.service.activityService;
import com.VolunServices.service.recordService;
import com.VolunServices.service.userInfoService;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class WriteToExcel {
	
	@Autowired
	private recordService recordservice;
	
	@Autowired
	private activityService activityservice;
	
	@Autowired
	private userInfoService userinfoservice;
	
	/*�漰Record��uid,actid��ʱ��,Activity��ʱ�䡢���ƺ�ʱ�����Userinfo����û�ID����������ϵ��ʽ*/
	/*pathΪ���ɵ��ļ���*/
	public boolean writeRecord(int actid){
		boolean flag = false;
		//������
		String title[] = {"�û�ID","�û���","��ϵ��ʽ","ʱ��","��ע"};
		//����actid����activity������Ҫ��ȡ����Ϣ
		Activity selectByAid = activityservice.SelectByAid(actid);
		String ActName = selectByAid.getAname();
		Timestamp date = selectByAid.getDay();
		String actaddress = selectByAid.getActaddress();
		//�����ı�׼ʱ��
		Float duration = selectByAid.getDuration();
		
		List WRlist = new ArrayList<WriteRecordToExcel>();
		//����actid����Record������Ҫ��ȡ����Ϣ
		List<Record> recordlist = recordservice.SelByActId(actid);
		for (Record record : recordlist)
		 {
			Integer uid = record.getUid();
			//��ȡÿ��־Ը�ߵ�userinfo������Ҫ��ȡ����Ϣ
			Userinfo persondetaild = userinfoservice.Persondetaild(uid); //��Ϊuser�е�id��userinfo��uIid��һ�µ�
			String uiname = persondetaild.getUiname();
			String tel = persondetaild.getTel();
			Float personduration = record.getDuration();
			WriteRecordToExcel WR = new WriteRecordToExcel(uid,uiname,tel,personduration,"");
			WRlist.add(WR);
		} 
		
		//����Excel
		 try {
			//�ļ�·��������
			WritableWorkbook book= Workbook.createWorkbook(new File(ActName+"("+date+").xls"));
			//������Ϊ�������¼���Ĺ���������0��ʾ���ǵ�һҳ
			WritableSheet sheet=book.createSheet("�����¼��",0);
			//д������
			for (int i = 0;i<WRlist.size();i++) {
//				sheet.addCell(arg0);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}

}
