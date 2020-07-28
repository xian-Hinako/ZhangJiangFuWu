package com.VolunServices.util;

import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class SendUtil {     
	public static HashMap<String,String> getMessageStatus(String phone) throws IOException {        
		HashMap<String,String> hashMap = new HashMap<>();        //������ƽ̨��վ��ַ http://www.webchinese.com.cn/User/?action=pay        
		PostMethod post = new PostMethod("http://utf8.api.smschinese.cn/");        
		post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");        
		String randMun = String.valueOf(RandomUtil.getRandNum());        //����ģ��        
		NameValuePair[] data ={                
				new NameValuePair("Uid", "տ��־Ը�߷���ƽ̨"),  //sms����ͨ ע����û���                
				new NameValuePair("Key", "d41d8cd98f00b204e980"), //�ܳ�                
				new NameValuePair("smsMob",phone),//Ҫ���͵��ֻ���                
				new NameValuePair("smsText","��֤��:"+randMun+"������")//��������        
//				new NameValuePair("smsText","���ǲ�����Ϣ")//��������      
				};        
		post.setRequestBody(data);        
		HttpClient client = new HttpClient();        
		client.executeMethod(post);        //��ȡhttpͷ        
		Header[] headers = post.getResponseHeaders();        
		int statusCode = post.getStatusCode();        
		System.out.println("statusCode:"+statusCode);         
		for(Header h:headers){            
			System.out.println(h.toString());        
			}        //��ȡ������Ϣ        
		String result = new String(post.getResponseBodyAsString().getBytes("utf-8"));        
		System.out.println(result); //��ӡ������Ϣ״̬        
		//��������Ϣ��6λ����֤����뵽map�б�����        
		hashMap.put("result", result);        
		hashMap.put("code", randMun);        //�Ͽ��������ƽ̨������        
		post.releaseConnection();        
		return hashMap;    
		} 
}

