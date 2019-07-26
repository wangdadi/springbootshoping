package com.wd.springboot.springbootshoping.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * ClassName:ImageUtil
 * Package:com.wd.springboot.springbootshoping.util
 * Description:
 * 图片处理工具类
 * @Date:2019/5/5 0005 20:25
 * @Author:王迪
 */
public class ImageUtil {
    /**
     * 使用线程读取resource文件下的图片
     */
    private static String basePath=Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random random=new Random();
    /**
     *
     * @param multipartInputStream Spring文件处理对象
     * @param tagertAddr  文件存放地址
     * @return
     */
    public static String generateThumbnail(InputStream multipartInputStream,String tagertAddr, String fileName){

        String realFileName=getRandomFileName();

        String extension=getFileExtension(tagertAddr);

        makeDirPath(fileName);
        /**
         * 生成文件相对路径
         */
        String relativeAddr=fileName+realFileName+extension;
        File dest=new File(PathUtil.getImageBasePath()+relativeAddr);
        /**
         * 产生水印后图片
         */
        try {
            Thumbnails.of(multipartInputStream)
                    .size(200,200)
                    .watermark(Positions.BOTTOM_RIGHT,
                            ImageIO.read(new File(basePath+"/touxiang.jpg")),
                            0.5f)
                    .outputQuality(0.8f).toFile(dest);
        }catch (IOException e){
            e.printStackTrace();
        }
        return PathUtil.getImageBasePath()+relativeAddr;

    }

    /**
     * 创建图片文件目录
     * @param fileName
     */
    private static void makeDirPath(String fileName) {
        //获取目标文件全绝对路径
        String realFileParentPath=PathUtil.getImageBasePath()+fileName;
        File dirPath=new File(realFileParentPath);
        if (!dirPath.exists()){
            dirPath.mkdirs();
        }
    }

    /**
     * 获取用户上传图片的扩展名  .jpg .gtf ...
     * @param tagertAddr
     * @return
     */
    private static String getFileExtension(String tagertAddr) {
        //获取用户上传文件名
       //String originalFileName=file.getOriginalFilename();
        //截取文件后缀
       if (tagertAddr!=null&&tagertAddr.length()>0){
            return tagertAddr.substring(tagertAddr.lastIndexOf("."));
       }else {
           throw new RuntimeException();
       }
    }
    /**
     * 生成随机图片文件名 年月日时分秒+5位随机数
     * @return
     */
    public static String getRandomFileName() {
        int rannum=random.nextInt(89999)+10000;
        String nowTime=format.format(new Date());
        return nowTime+rannum;
    }

    public static void main(String[] args) throws IOException {
        Thumbnails.of(new File("D:\\1.jpg"))
                /**
                 * 输出图片的大小
                 */
                .size(1600,1066)
                /**
                 * 为图片添加水印 水印的位置,水印图片的位置,透明度
                 */
                .watermark(Positions.BOTTOM_RIGHT,
                        ImageIO.read(new File(basePath+"/touxiang.jpg")),
                        0.5f)
                /**
                 * 压缩原来图片的80%
                 */
                .outputQuality(0.8f).toFile("\\1new.jpg");
    }

    /**
     * 判断storePath(存储路径)是文件还是文件目录
     * 在更新图片时判断图片是否已经存在,如果已经存在则需要删除原有图片或路径
     * @param storePath
     */
    public static void deleteFileOrPath(String storePath){
        File fileOrPath=new File(storePath);
        if (fileOrPath.exists()){
            //如果是文件夹
            if (fileOrPath.isDirectory()){
                File file[] =fileOrPath.listFiles();
                for (int i=0;i<file.length;i++){
                    file[i].delete();
                }
            }
        }
        fileOrPath.delete();
    }
}
