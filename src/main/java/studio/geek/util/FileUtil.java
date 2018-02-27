package studio.geek.util;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import studio.geek.exception.ErrorException;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 凌龙
 * @version 2017/2/24.
 */


@Component
public class FileUtil {


    @Autowired
    ServletContext servletContext;

    /**
     * 上传功能实现
     *
     * @param file
     * @return
     */
    public String upload(MultipartFile file) {
        List<String> fileTypes = new ArrayList();
        fileTypes.add("jpg");
        fileTypes.add("jpeg");
        fileTypes.add("gif");
        fileTypes.add("png");
        String fileName = file.getOriginalFilename();//得到上传时文件名
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
        //截取文件后缀(格式)
        ext = ext.toLowerCase();//转为小写
        String path;
        String effectPictureAddress;
        if (fileTypes.contains(ext)) {                      //如果扩展名属于允许上传的类型
            try {
                System.out.println(file.getContentType());
                effectPictureAddress = "image" + File.separator
                        + System.currentTimeMillis() + file.getOriginalFilename();
                path = servletContext.getRealPath("/")
                        //不同服务器(Tomcate)getRealPath的实现不一样
                        + effectPictureAddress;
                FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path));
            } catch (IOException e3) {
                throw new ErrorException("图片上传失败");
            }
        } else {
            throw new ErrorException("文件类型不支持");
        }
        return effectPictureAddress;
    }

    public boolean delete(String effectPicture) {
        String path = servletContext.getRealPath("/")
                + effectPicture;
        FileUtils.deleteQuietly(new File(path));
        return true;
    }
}
