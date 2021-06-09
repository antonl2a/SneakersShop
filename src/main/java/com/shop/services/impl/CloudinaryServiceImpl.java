package com.shop.services.impl;

import com.cloudinary.Cloudinary;
import com.shop.services.CloudinaryService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;

@Service
public class CloudinaryServiceImpl implements CloudinaryService {
    private final Cloudinary cloudinary;

    public CloudinaryServiceImpl(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Override
    public String uploadImage(MultipartFile multipartFile) throws IOException {
        File tmpFile = File.createTempFile("tmp", multipartFile.getOriginalFilename());
        multipartFile.transferTo(tmpFile);

        return cloudinary.
                uploader().
                upload(tmpFile, Collections.emptyMap()).
                get("url").
                toString();
    }
}
