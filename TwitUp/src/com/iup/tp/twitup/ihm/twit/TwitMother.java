package com.iup.tp.twitup.ihm.twit;

import com.iup.tp.twitup.common.Constants;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class TwitMother extends JPanel {

    protected ResourceBundle fileLanguage;
    protected Dimension screenSize;

    public TwitMother() {
        this.fileLanguage = ResourceBundle.getBundle(Constants.MENU, Locale.getDefault());
        this.screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    }

    protected void addInto(JPanel panel, JComponent componentToAdd, int gridX, int gridY, int gridWidth, int gridHeight, int weightX, double weightY, int constraint, int constraint1, int top, int left, int bottom, int right, int ipadX, int ipadY){
        panel.add(componentToAdd, new GridBagConstraints(gridX,gridY,gridWidth,gridHeight,weightX,weightY,constraint,constraint1, new Insets(top,left,bottom,right),ipadX,ipadY ));
    }
}
