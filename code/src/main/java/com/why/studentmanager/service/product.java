package com.why.studentmanager.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface product {
    Map<String, String> uploadImg(MultipartFile file);
}
