package com.eclockin.sevice;

import com.eclockin.ui.LoginFrame;

import javax.swing.*;
import java.awt.*;

public class Login {
    public static void main(String[] args) {
        try {
            JFrame frame = new LoginFrame();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
