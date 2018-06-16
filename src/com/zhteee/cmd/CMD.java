package com.zhteee.cmd;

import com.zhteee.MakeNewRegedit;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CMD {

    public static String imgPath ;
	
	public static void doCMD(String manufacturer,String model) throws IOException {

        List<String> list = new ArrayList<>();

        list.add("cmd /c md C:\\OEM");//创建目录

        if (imgPath!=""&&imgPath!=null){
            list.add("cmd /c copy "+imgPath+" C:\\OEM"); //将选中图片加入到指定目录
            String[] img = imgPath.split("\\\\");
            MakeNewRegedit.imgPath=("C:\\OEM\\"+img[img.length-1]).replaceAll("\\\\","\\\\\\\\");
        }

        for (String string : list) {
            Runtime.getRuntime().exec(string); //执行CMD命令
        }

        MakeNewRegedit.regedit(manufacturer,model); //生成.regedit文件
        GetAdmin.regedit();//生成.bat文件
        Runtime.getRuntime().exec("C:\\OEM\\run.bat"); //运行.bat文件

//      JOptionPane.showMessageDialog(MyJFrame.massage, "修改成功！", "提示",JOptionPane.INFORMATION_MESSAGE); //提示消息

    }
}
