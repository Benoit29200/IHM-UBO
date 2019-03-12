package com.iup.tp.twitup.common.helper;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageHelper {

    public static ImageIcon getImageResize(ImageIcon image, int width, int height){
        ImageIcon icon = new ImageIcon("tonImage.jpg");
        Image img = icon.getImage();
        BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics g = bi.createGraphics();
        g.drawImage(img, 0, 0, width, height, null);
        return new ImageIcon(bi);
    }
}
