package com.example.getmesocialservice.resource;

import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.example.getmesocialservice.service.FileService;
import io.swagger.v3.oas.annotations.media.Content;
import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.session.HeaderWebSessionIdResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@RestController
@RequestMapping(value = "/api/files")
@CrossOrigin(origins = "http://localhost:4200")
public class FileResource {
        @Autowired
         private FileService fileService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping( consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> upload(@RequestParam(name="file") MultipartFile file) throws IOException {
        return fileService.upload(file);
    }

    @GetMapping("/{id}")
    public void view(@PathVariable("id") String key, HttpServletResponse response) throws IOException {
        S3Object object =  fileService.getFile(key);
        response.setContentType(object.getObjectMetadata().getContentType());
        response.getOutputStream().write(object.getObjectContent().readAllBytes());
    }

    @GetMapping("/download")
    public ResponseEntity<org.springframework.core.io.Resource> download(@RequestParam(name = "key") String key) throws IOException {
        S3Object object =  fileService.getFile(key);

        ByteArrayResource resource = new ByteArrayResource(object.getObjectContent().readAllBytes());
        return (ResponseEntity.ok().contentType(MediaType.parseMediaType(object.getObjectMetadata().getContentType()))
                .header(Headers.CONTENT_DISPOSITION,"attachment;filename=\""+key+"\"")
                .body(resource));
    }

    @DeleteMapping
    public void delete(@RequestParam("key") String key){
        fileService.deleteFile(key);
    }

}
