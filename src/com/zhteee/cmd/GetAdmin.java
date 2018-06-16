package com.zhteee.cmd;

import java.io.*;

public class GetAdmin {


     public static void regedit() throws IOException {

        String bat;//bat文件内容

        File f=new File("C:\\OEM\\run.bat");

        OutputStreamWriter outputStreamWriter;

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

         outputStreamWriter = new OutputStreamWriter(new FileOutputStream(f),"GB2312");
         outputStreamWriter.append(bat);
         outputStreamWriter.close();

    }
}
