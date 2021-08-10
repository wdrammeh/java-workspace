package io;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class MyClass {
    public static final String MY_DIRECTORY = "/home/muhammed/instantFiles";

    public static Icon scaleForMe(File file, int width, int height) {
        Icon ic = null;
        try {
            BufferedImage buf = ImageIO.read(file);
            ic = new ImageIcon(buf.getScaledInstance(width, height, Image.SCALE_SMOOTH));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ic;
    }

    public static Icon scaleForMe(URL resource, int width, int height) {
        Icon ic = null;
        try {
            BufferedImage buf = ImageIO.read(resource);
            ic = new ImageIcon(buf.getScaledInstance(width, height, Image.SCALE_SMOOTH));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ic;
    }

    public static Icon rescaleForMe(Icon icon, int w, int h){

        //already, you have the how to rescale it?
        return null;
    }


    public static int[] considerUpperHalf(int[] a) {
        int mid_index;
        int[] b = null;

        if (a.length %2 == 0) {
            mid_index = (a.length/2);
            b = new int[mid_index];

            int i = 0;
            while (mid_index < a.length) {
                b[i] = a[mid_index];

                i++;
                mid_index++;
            }
        } else {
            mid_index = (a.length/2)+1;
            b = new int[mid_index];

            int t = mid_index - 1;
            for (int i = 0; i < mid_index; i++) {
                b[i] = a[t];
                t++;
            }
        }

        return b;
    }

    public static int[] considerLowerHalf(int[] a) {
        int mid_index = 0;
        if (a.length %2 == 0) {
            mid_index = a.length/2;
        } else {
            mid_index = (a.length/2)+1;
        }
        int[] b = new int[mid_index];

        for (int i = 0; i < mid_index; i++) {
            b[i] = a[i];
        }
        return b;
    }
}
