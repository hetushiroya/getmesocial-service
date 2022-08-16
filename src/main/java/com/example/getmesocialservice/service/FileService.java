package com.example.getmesocialservice.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {

    public ResponseEntity<String> upload(MultipartFile file) throws AmazonServiceException, IOException {

      BasicAWSCredentials credentials =
              new BasicAWSCredentials("AKIA37F3S25HW6ZP5NVD","RPPq2RNPCo8iko8+2DrChXp5cucz+eckW5AwKBDn\n");

    ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType());

        final AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.CA_CENTRAL_1).build();

        // message = "Uploaded the file successfully: " + file.getOriginalFilename();
        s3.putObject("backend1-spring",file.getOriginalFilename(),file.getInputStream(),metadata);

        String message = file.getOriginalFilename();
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

    public S3Object getFile(String key){
        BasicAWSCredentials credentials =
                new BasicAWSCredentials("AKIA37F3S25HW6ZP5NVD","RPPq2RNPCo8iko8+2DrChXp5cucz+eckW5AwKBDn\n");

        final AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.CA_CENTRAL_1).build();

        return s3.getObject("backend1-spring", key);

    }

    public void deleteFile(String key){
        BasicAWSCredentials credentials =
                new BasicAWSCredentials("AKIA37F3S25HW6ZP5NVD","RPPq2RNPCo8iko8+2DrChXp5cucz+eckW5AwKBDn\n");

        final AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.CA_CENTRAL_1).build();

        s3.deleteObject("backend1-spring", key);

    }



}

