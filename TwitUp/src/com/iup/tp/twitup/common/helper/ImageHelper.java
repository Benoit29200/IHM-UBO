package com.iup.tp.twitup.common.helper;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageHelper {

    public static ImageIcon getImageResize(ImageIcon image, int width, int height){
        Image img = image.getImage();
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics g = bi.createGraphics();
        g.drawImage(img, 0, 0, width, height, null);
        return new ImageIcon(bi);
    }
}
