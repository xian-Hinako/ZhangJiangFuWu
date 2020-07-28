package com.VolunServices.util;

public class RandomUtil {
	
	//随机得到4位数

    public static int getRandNum() {

        return (int)((Math.random()*9+1)*1000);

    }
}
