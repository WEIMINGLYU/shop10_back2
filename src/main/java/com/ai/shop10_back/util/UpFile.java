package com.ai.shop10_back.util;


import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

public class UpFile {
    public static String upFile(String fileName, String realPath, MultipartFile photo){
        //避免用户上传文件名是中文，出现不能正常显示图片的问题，所以需要给上传的文件重名名。
        String substring = fileName.substring(fileName.lastIndexOf("."));
        //通过UUID的方式给源文件名字重命名。
        fileName = UUID.randomUUID() + substring;

        //避免老浏览器上传的文件带有路径，如果是路径和文件名，截取一下
        fileName = fileName.substring(fileName.lastIndexOf(File.separator) + 1);

        if (fileName != null) {
            String fileName2 = fileName.substring(fileName.lastIndexOf("."));
            if (".JPG".equalsIgnoreCase(fileName2) || ".JPEG".equalsIgnoreCase(fileName2) || ".png".equalsIgnoreCase(fileName2) || ".bmp".equalsIgnoreCase(fileName2) || ".gif".equalsIgnoreCase(fileName2)) {
		        	/* //避免重复命名覆盖源文件，在原文件名前加个32位的
		    		fileName = UUID.randomUUID()+"_"+fileName;*/

                //在服务器里创建文件夹
                File storyFile = new File(realPath);
                if (!storyFile.exists()) {
                    storyFile.mkdirs();
                }
            } else {

                //在服务器里创建文件夹
                File storyFile = new File(realPath+"/WEB-INF/upload");
                if (!storyFile.exists()) {
                    storyFile.mkdirs();
                }
                //创建文件对象
            }
        }
        /*文件名+扩展名*/
        File photo2 = new File(fileName);

        //创建outPutStream文件对象，向服务器中写入内容
        OutputStream os = null;
        InputStream is = null;
        String imagePath = realPath + "/" + photo2;
        try {
            os = new FileOutputStream(imagePath);
            is = photo.getInputStream();
            byte[] b = new byte[1024];
            int len = 0;
            while ((len = is.read(b)) != -1) {
                os.write(b, 0, len);
            }
            imagePath = imagePath.substring(imagePath.lastIndexOf("upload/"));

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.close();
                    os = null;
                }
                if (is != null) {
                    is.close();
                    is = null;
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return imagePath;
    }
}
