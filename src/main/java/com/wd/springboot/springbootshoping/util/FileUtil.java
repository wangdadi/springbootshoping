package com.wd.springboot.springbootshoping.util;

import java.io.*;

/**
 * ClassName:FileUtil
 * Package:com.wd.springboot.springbootshoping.util
 * Description:
 * CommonsMultipart.getInputStream()得到File
 * @Date:2019/5/19 0019 15:08
 * @Author:王迪
 */
public class FileUtil {
    public static void inputStreamToFile (InputStream inputStream, File file){
        FileOutputStream outputStream=null;
        try {
            outputStream=new FileOutputStream(file);
            int byteRead=0;
            byte [] bytes=new byte[1024];
            while ((byteRead=inputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,byteRead);
            }
        }catch (Exception e){
            throw new RuntimeException("调用inputStreamToFile产生异常:"+e.getMessage());
        }finally {
            try {
                if (outputStream!=null){
                    outputStream.close();
                }
                if (inputStream!=null){
                    inputStream.close();
                }
            }catch (IOException e){
                throw new RuntimeException("调用inputStreamToFile关闭资源产生异常:"+e.getMessage());
            }
        }
    }
}
