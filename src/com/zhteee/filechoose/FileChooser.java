package com.zhteee.filechoose;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.util.Properties;

public class FileChooser {

    //打开文件选择器
    public static String fileChooser() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        String fileName = "";
        Properties prop = System.getProperties();
        String userName = prop.getProperty("user.name");
        JFileChooser jfc=new JFileChooser("C:\\Users\\"+userName+"\\Desktop");
        BmpFileFilter bmpFilter = new BmpFileFilter(); //文件过滤器
        jfc.addChoosableFileFilter(bmpFilter);
        jfc.setFileFilter(bmpFilter);
        jfc.showDialog(new JLabel(), "选择");
        File file=jfc.getSelectedFile();
        if(file!=null&&file.isFile()){
            fileName = file.getAbsolutePath();
        }
        return fileName;
    }
}
//文件过滤器
class BmpFileFilter extends FileFilter {
    public String getDescription() {

        return "*.bmp";

    }

    public boolean accept(File file) {
        String name = file.getName();
        return file.isDirectory() || name.toLowerCase().endsWith(".bmp");  // 仅显示目录和bmp文件
    }
}