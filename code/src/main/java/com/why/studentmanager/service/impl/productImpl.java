package com.why.studentmanager.service.impl;

import com.why.studentmanager.service.product;
import com.why.studentmanager.until.RandomUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class productImpl implements product {

    @Value("${absoluteImgPath}")
    String absoluteImgPath;

    @Value("${sonImgPath}")
    String sonImgPath;


    @Override
    public Map<String, String> uploadImg(MultipartFile file) {
        Map<String,String> map = new HashMap<>();
        if(file.isEmpty()){
            map.put("code","500");
            map.put("msg","图片不能为空");
            return map;
        }
        String originalFilename = file.getOriginalFilename();
        //随机生成文件名
        String fileName = RandomUtils.createRandomString(10) + originalFilename;
        File dest = new File(absoluteImgPath + fileName);
        System.out.println(absoluteImgPath + fileName);
        String imgUrl = sonImgPath +fileName;
        try{
            file.transferTo(dest);
            map.put("code","200");
            map.put("msg","上传成功");
            map.put("imgUrl",imgUrl);
            return map;
        }catch (IllegalStateException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return map;
    }
}
