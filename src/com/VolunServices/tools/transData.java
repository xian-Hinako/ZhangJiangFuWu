package com.VolunServices.tools;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class transData{
	//将String类型的day转换成date类型
//	 public void setAsText(String source) throws IllegalArgumentException {
//	        SimpleDateFormat sdf = getDateFromte(source);
//	        Date date = null;
//	        try {
//	            date = (Date) sdf.parse(source);
//	            setValue(date);
//	        } catch (ParseException e) {
//	            e.printStackTrace();
//	        }
//	    }
////
//	    private SimpleDateFormat getDateFromte(String source) {
//
//	        SimpleDateFormat sdf = new SimpleDateFormat();
//
//	        if (Pattern.matches("^\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{1,2}:\\d{2}:\\d{2}$", source)) {
//	            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	        }
//	        if (Pattern.matches("^\\d{4}/\\d{1,2}/\\d{1,2}\\s\\d{1,2}:\\d{2}:\\d{2}$", source)) {
//	            sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//	        }
//	        if (Pattern.matches("^\\d{4}\\d{1,2}\\d{1,2}\\s\\d{1,2}:\\d{2}:\\d{2}$", source)) {
//	            sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
//	        }
//	        if (Pattern.matches("^\\d{4}年\\d{1,2}月\\d{1,2}日\\s\\d{1,2}时\\d{2}分\\d{2}秒$", source)) {
//	            sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
//	        }
//	        return sdf;
//	    }
 
	    public Date turndate(String hiredate){
	    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    	Date date = null;
			try {   		                //将String类型的hiredate转换为Date类型的date
				date = (Date) df.parse(hiredate);  			  
				} catch (ParseException e) {   		  
				e.printStackTrace();  			  
				} 
			return date;
	    }

	}
