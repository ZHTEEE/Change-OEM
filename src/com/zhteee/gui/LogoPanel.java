package com.zhteee.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LogoPanel extends JPanel {

    private Image image;

    private static String imagePath;

    public static void setImage(String imgPath){
            imagePath = imgPath;
    }

    public void paint(Graphics g) {
        try {
            if (imagePath!=null){
                image = ImageIO.read(new File(imagePath));
            }else{
                image = ImageIO.read(this.getClass().getResource("default.bmp"));
            }
            g.drawImage(image, 0, 0, 151, 151, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
