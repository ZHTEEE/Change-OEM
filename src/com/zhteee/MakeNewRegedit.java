package com.zhteee;

import java.io.*;

public class MakeNewRegedit {

	public static String imgPath;

public static void regedit(String manufacturer,String model) throws IOException {

	File f=new File("C:\\OEM\\OEM信息.reg");

	OutputStreamWriter  outputStreamWriter;

	//拼接注册表文件内容
	String str0 = "Windows Registry Editor Version 5.00";
	str0 += "\r\n \r\n";
	str0 += "\r\n "+"[HKEY_LOCAL_MACHINE\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\OEMInformation]";
	str0 += "\r\n "+ "\"Manufacturer\"=\""+manufacturer+"\"";
	str0 += "\r\n "+"\"Model\"=\""+model+"\"";
	str0 += "\r\n "+"\"Logo\"=\""+imgPath+"\"";


	outputStreamWriter = new OutputStreamWriter(new FileOutputStream(f),"GB2312");
	outputStreamWriter.append(str0);
	outputStreamWriter.close();

	}
}
