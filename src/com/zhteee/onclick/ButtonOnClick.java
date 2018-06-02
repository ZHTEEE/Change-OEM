package com.zhteee.onclick;

import com.zhteee.cmd.CMD;
import com.zhteee.gui.MyJFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ButtonOnClick implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            startChange();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    private void startChange() throws IOException {
        String manufacturer = MyJFrame.Manufacturer.getText();
        String model = MyJFrame.Model.getText();
        CMD.doCMD(manufacturer,model);
    }
}
