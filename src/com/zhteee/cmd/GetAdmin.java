package com.zhteee.cmd;

import java.io.*;

public class GetAdmin {

    private static String bat;

     public static void regedit()  {
        File f=new File("C:\\OEM\\run.bat");
        if (!f.exists()){
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        OutputStreamWriter ps;
        try {
           bat = "@echo off";
            bat += "\r\n"+">nul 2>&1 \"%SYSTEMROOT%\\system32\\cacls.exe\" \"%SYSTEMROOT%\\system32\\config\\system\"" ;
            bat += "\r\n"+"if '%errorlevel%' NEQ '0' (  " ;
            bat += "\r\n"+"goto UACPrompt  " ;
            bat += "\r\n"+") else ( goto gotAdmin )  " ;
            bat += "\r\n"+":UACPrompt  " ;
            bat += "\r\n"+"echo Set UAC = CreateObject^(\"Shell.Application\"^) > \"%temp%\\getadmin.vbs\" " ;
            bat += "\r\n"+"echo UAC.ShellExecute \"%~s0\", \"\", \"\", \"runas\", 1 >> \"%temp%\\getadmin.vbs\" " ;
            bat += "\r\n"+" \"%temp%\\getadmin.vbs\" " ;
            bat += "\r\n"+"exit /B  " ;
            bat += "\r\n"+":gotAdmin  " ;
            bat += "\r\n"+"if exist \"%temp%\\getadmin.vbs\" ( del \"%temp%\\getadmin.vbs\" )  " ;
            bat += "\r\n"+"pushd \"%CD%\" " ;
            bat += "\r\n"+"CD /D \"%~dp0\" " ;
            bat += "\r\n"+":begin" ;
            bat += "\r\n"+"regedit C:\\\\OEM\\\\OEM信息.reg";

            ps = new OutputStreamWriter(new FileOutputStream(f),"GB2312");
            ps.append(bat);
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
