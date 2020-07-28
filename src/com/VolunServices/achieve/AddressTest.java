package com.VolunServices.achieve;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.io.UnsupportedEncodingException;

import me.hupeng.ipLocationService.IpLocationResult;
import me.hupeng.ipLocationService.IpLocationService;

public class AddressTest {

	 public static void main(String[] args) throws SocketException, UnknownHostException {
		 distinguishIp d = new distinguishIp();
//		 System.out.println(d.getaddress());
		 
		 getLocalIp Ip1 = new getLocalIp();
		 System.out.println("Ip1 "+Ip1.getIp());
		 
//		 System.out.println("×îÐÂ "+Ip1.getWebIP());
	 }

}
