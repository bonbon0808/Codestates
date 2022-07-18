package com.codestates.coffee.service;

import org.springframework.web.multipart.MultipartFile;

public class S3StorageService implements StorageService {
    @Override
    public void store(MultipartFile file) {
        // TODO S3 API를 이용해서 AWS S3로 업로드 한다.
    }
}
