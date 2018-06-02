package com.zhteee;

import java.io.*;

public class MakeNewRegedit {

	public static String imgPath;

public static void regedit(String manufacturer,String model)  {
	File f=new File("C:\\OEM\\OEM信息.reg");
	if (!f.exists()){
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	OutputStreamWriter  ps;
	try {
		String str0 = "Windows Registry Editor Version 5.00";
				str0 += "\r\n \r\n";
				str0 += "\r\n "+"[HKEY_LOCAL_MACHINE\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\OEMInformation]";
				str0 += "\r\n "+ "\"Manufacturer\"=\""+manufacturer+"\"";
				str0 += "\r\n "+"\"Model\"=\""+model+"\"";
		String str1 = "\r\n "+"\"Logo\"=\""+imgPath+"\"";

		ps = new OutputStreamWriter(new FileOutputStream(f),"GB2312");
		ps.append(str0);
		if (imgPath!=""&&imgPath!=null){
			ps.append(str1);
		}
		ps.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
