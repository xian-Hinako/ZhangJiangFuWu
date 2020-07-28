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
	
	/*涉及Record表uid,actid和时长,Activity的时间、名称和时长表和Userinfo表的用户ID、姓名和联系方式*/
	/*path为生成的文件名*/
	public boolean writeRecord(int actid){
		boolean flag = false;
		//标题行
		String title[] = {"用户ID","用户名","联系方式","时长","备注"};
		//根据actid查找activity表中需要获取的信息
		Activity selectByAid = activityservice.SelectByAid(actid);
		String ActName = selectByAid.getAname();
		Timestamp date = selectByAid.getDay();
		String actaddress = selectByAid.getActaddress();
		//这个活动的标准时长
		Float duration = selectByAid.getDuration();
		
		List WRlist = new ArrayList<WriteRecordToExcel>();
		//根据actid查找Record表中需要获取的信息
		List<Record> recordlist = recordservice.SelByActId(actid);
		for (Record record : recordlist)
		 {
			Integer uid = record.getUid();
			//获取每个志愿者的userinfo表中需要获取的信息
			Userinfo persondetaild = userinfoservice.Persondetaild(uid); //因为user中的id和userinfo的uIid是一致的
			String uiname = persondetaild.getUiname();
			String tel = persondetaild.getTel();
			Float personduration = record.getDuration();
			WriteRecordToExcel WR = new WriteRecordToExcel(uid,uiname,tel,personduration,"");
			WRlist.add(WR);
		} 
		
		//处理Excel
		 try {
			//文件路径和名字
			WritableWorkbook book= Workbook.createWorkbook(new File(ActName+"("+date+").xls"));
			//生成名为“服务记录表”的工作表，参数0表示这是第一页
			WritableSheet sheet=book.createSheet("服务记录表",0);
			//写入内容
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
