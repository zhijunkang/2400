package com.gl.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Calendar;
import java.util.Date;

import javax.crypto.Cipher;

import org.come.tool.ReadExelTool;
import org.come.until.ReadTxtUtil;




public class MacVerify {

	 public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, +100);//+1今天的时间加一天
        Date date = calendar.getTime();
		System.out.println(date);
		System.out.println(date.getTime());
	}
	    
}
