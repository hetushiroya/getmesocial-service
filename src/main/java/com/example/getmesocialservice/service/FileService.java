package com.example.getmesocialservice.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {

    public boolean upload(MultipartFile file){

      BasicAWSCredentials credentials =
              new BasicAWSCredentials("AKIA37F3S25HW6ZP5NVD","RPPq2RNPCo8iko8+2DrChXp5cucz+eckW5AwKBDn\n");

    ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType());

        final AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.CA_CENTRAL_1).build();

        try {
        s3.putObject("backend1-spring",file.getOriginalFilename(),file.getInputStream(),metadata);
        return true;
    } catch (AmazonServiceException | IOException e) {
            e.printStackTrace();
        return false;
    }
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

