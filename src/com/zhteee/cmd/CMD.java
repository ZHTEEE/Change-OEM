package com.zhteee.cmd;

import com.zhteee.MakeNewRegedit;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CMD {

    public static String imgPath ;
	
	public static void doCMD(String manufacturer,String model) throws IOException {
        List<String> list = new ArrayList<>();
        list.add("cmd /c md C:\\OEM");
        if (imgPath!=""&&imgPath!=null){
            list.add("cmd /c copy "+imgPath+" C:\\OEM");
            String[] img = imgPath.split("\\\\");
            MakeNewRegedit.imgPath=("C:\\OEM\\"+img[img.length-1]).replaceAll("\\\\","\\\\\\\\");
        }
        try {
            for (String string : list) {
                Runtime.getRuntime().exec(string);
            }
            MakeNewRegedit.regedit(manufacturer,model);
            GetAdmin.regedit();
            Runtime.getRuntime().exec("C:\\OEM\\run.bat");
//            JOptionPane.showMessageDialog(MyJFrame.massage, "修改成功！", "提示",JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
