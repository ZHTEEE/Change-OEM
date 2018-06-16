package com.zhteee.onclick;

import com.zhteee.cmd.CMD;
import com.zhteee.filechoose.FileChooser;
import com.zhteee.gui.LogoPanel;
import com.zhteee.gui.MyJFrame;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JpanelOnClick implements MouseListener {

    private String imagePath;

    @Override
    public void mouseClicked(MouseEvent e) {

        try {

            imagePath = FileChooser.fileChooser();

        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (UnsupportedLookAndFeelException e1) {
            e1.printStackTrace();
        } catch (InstantiationException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        }

        if (imagePath!=""&&imagePath!=null){
            MyJFrame.logoPanel.setImage(imagePath);
            MyJFrame.logoPanel.updateUI();
            CMD.imgPath = imagePath;
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
