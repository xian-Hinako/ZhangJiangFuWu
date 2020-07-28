package com.VolunServices.fileUpAndDow;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

public class AchieveNews {
	public static void main(String[] args){
		String url="http://www.news.cn/whxw.htm";
		ArrayList<String> rt= getNodeList(url);
		for (int i = 0; i < rt.size(); i++){
		System.out.println(rt.get(i));
	    }
	}
	
	public static ArrayList<String> getNodeList(String url){
		final ArrayList<String> result=new ArrayList<String>();
		Parser parser = null;
		NodeList nodeList=null;
		try {
		parser = new Parser(url);
		parser.setEncoding("UTF-8");
		nodeList = parser.parse(
		new NodeFilter(){
		@Override
		public boolean accept(Node node){
		Node need=node;
		if(getStringsByRegex(node.getText())){
		for(int i=0;i<2;i++){
		result.add(need.toPlainTextString()); need=need.getPreviousSibling().getPreviousSibling();
		}
		return true;
		}
		return false;
		}
		}
		);
		}catch (ParserException e) {
		e.printStackTrace();
		}
		return result;
		}
	
		public static boolean getStringsByRegex(String txt) {
		String regex="li class=\"clearfix\"";  
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(txt);
		if (m.find()){
		return true;
		}
		return false;
		}
		
}
