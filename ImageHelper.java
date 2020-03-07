package com.dhcc.avatar.service.knowledgeweb_service.test1;



import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Iterator;

public class ImageHelper {
    public static void cutHalfImage(String src,String dest) throws IOException {
        Iterator iterator = ImageIO.getImageReadersByFormatName("jpg");
        ImageReader reader = (ImageReader)iterator.next();
        InputStream in=new FileInputStream(src);
        ImageInputStream iis = ImageIO.createImageInputStream(in);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        int imageIndex = 0;
//        int width = reader.getWidth(imageIndex)/2;
//        int height = reader.getHeight(imageIndex)/2;
        int width = reader.getWidth(imageIndex);
        int height = reader.getHeight(imageIndex);
        Rectangle rect = new Rectangle(0, 0, width, height);
        param.setSourceRegion(rect);
        BufferedImage bi = reader.read(0,param);
        ImageIO.write(bi, "jpg", new File(dest));
    }
    public static void main(String[] args) {
        File f = new File("/Users/dh/Desktop/anmo");
        File files[] = f.listFiles();

        for (File aa :files) {
//         String src =  files[2].getAbsolutePath();
            String src =  aa.getAbsolutePath();
         String dest = src.replace("IMG_","");
            //System.out.println(dest);
            try {
                cutHalfImage(src,dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //cutHalfImage();

    }
}
