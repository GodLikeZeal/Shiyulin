package com.zeal.shiyulin.utils;

import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;


/**
 * 纯JAVA实现的图片处理工具类
 *Created by zeal on 2017/7/15.
 */
public class ImageUtils {
    /*
   * 根据尺寸图片居中裁剪
   */
    public static void cutCenterImage(String src,String dest,int w,int h) throws IOException{
        Iterator iterator = ImageIO.getImageReadersByFormatName("jpg");
        ImageReader reader = (ImageReader)iterator.next();
        InputStream in=new FileInputStream(src);
        ImageInputStream iis = ImageIO.createImageInputStream(in);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        int imageIndex = 0;
        Rectangle rect = new Rectangle((reader.getWidth(imageIndex)-w)/2, (reader.getHeight(imageIndex)-h)/2, w, h);
        param.setSourceRegion(rect);
        BufferedImage bi = reader.read(0,param);
        ImageIO.write(bi, "jpg", new File(dest));

    }
    /*
     * 图片裁剪二分之一
     */
    public static void cutHalfImage(String src,String dest) throws IOException{
        Iterator iterator = ImageIO.getImageReadersByFormatName("jpg");
        ImageReader reader = (ImageReader)iterator.next();
        InputStream in=new FileInputStream(src);
        ImageInputStream iis = ImageIO.createImageInputStream(in);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        int imageIndex = 0;
        int width = reader.getWidth(imageIndex)/2;
        int height = reader.getHeight(imageIndex)/2;
        Rectangle rect = new Rectangle(width/2, height/2, width, height);
        param.setSourceRegion(rect);
        BufferedImage bi = reader.read(0,param);
        ImageIO.write(bi, "jpg", new File(dest));
    }

    /*
     * 图片裁剪通用接口
     */

    public static byte[] cutImage(MultipartFile sourceFile, int x, int y, int w, int h) throws IOException{
        Iterator iterator = ImageIO.getImageReadersByFormatName("jpg");
        ImageReader reader = (ImageReader)iterator.next();
        InputStream in=sourceFile.getInputStream();
        ImageInputStream iis = ImageIO.createImageInputStream(in);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        Rectangle rect = new Rectangle(x, y, w,h);
        param.setSourceRegion(rect);
        BufferedImage bi = reader.read(0,param);
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        ImageIO.write(bi, "jpg",byteArrayOutputStream );
        return byteArrayOutputStream.toByteArray();
    }
    /*
     * 图片缩放
     */
    public static void zoomImage(String src,String dest,int w,int h) throws Exception {
        double wr=0,hr=0;
        File srcFile = new File(src);
        File destFile = new File(dest);
        BufferedImage bufImg = ImageIO.read(srcFile);
        Image Itemp = bufImg.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        wr=w*1.0/bufImg.getWidth();
        hr=h*1.0 / bufImg.getHeight();
        AffineTransformOp ato = new AffineTransformOp(AffineTransform.getScaleInstance(wr, hr), null);
        Itemp = ato.filter(bufImg, null);
        try {
            ImageIO.write((BufferedImage) Itemp,dest.substring(dest.lastIndexOf(".")+1), destFile);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /**
     *合并图片
     * @param qrPosition_x
     * @param qrPosition_y
     * @param mainImg
     * @param slaveImg
     * @param qrWidth
     * @param qrHeight
     * @return String 上传到七牛云的链接
     */
    public void createPicTwo2(int qrPosition_x,int qrPosition_y,String mainImg, String slaveImg,int qrWidth,int qrHeight)
    {
        try
        {
            URL mainImgURL = new URL(mainImg);
            URL slaveImgURL = new URL(slaveImg);
            //读取第一张图片
            BufferedImage ImageOne = ImageIO.read(mainImgURL);
            int width = ImageOne.getWidth();//图片宽度
            int height = ImageOne.getHeight();//图片高度
            //从图片中读取RGB
            int[] ImageArrayOne = new int[width*height];
            ImageArrayOne = ImageOne.getRGB(0,0,width,height,ImageArrayOne,0,width);
            //对第二张图片做相同的处理
            BufferedImage ImageTwo = ImageIO.read(slaveImgURL);
            //新图片
            BufferedImage newImageTwo = resizeImg(qrWidth, qrHeight, ImageTwo);
            int widthTwo = newImageTwo.getWidth();//图片宽度
            int heightTwo = newImageTwo.getHeight();//图片高度
            int[] ImageArrayTwo = new int[widthTwo*heightTwo];
            ImageArrayTwo = newImageTwo.getRGB(0,0,widthTwo,heightTwo,ImageArrayTwo,0,widthTwo);

            //生成新图片
            BufferedImage ImageNew = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
            ImageNew.setRGB(0,0,width,height,ImageArrayOne,0,width);//设置左半部分的RGB  第一张图片
            ImageNew.setRGB(qrPosition_x,qrPosition_y,widthTwo,heightTwo,ImageArrayTwo,0,widthTwo);//设置右半部分的RGB


            File outFile = new File("G:\\out.png");
            ImageIO.write(ImageNew, "png", outFile);//写图片

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     *对图片进行缩放
     * @param tagetWidth 目标宽度
     * @param tagetHeight 目标高度
     * @param newImg
     * @return
     */
    public static BufferedImage resizeImg(int tagetWidth, int tagetHeight, BufferedImage newImg) {
        BufferedImage newImageTwo = new BufferedImage(tagetWidth, tagetHeight, newImg.getType());
        Graphics g = newImageTwo.getGraphics();
        g.drawImage(newImg, 0, 0, tagetWidth, tagetHeight, null); //画图
        g.dispose();
        return newImageTwo;
    }


}