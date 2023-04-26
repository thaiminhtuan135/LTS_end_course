package com.example.end_course.controller;

import com.example.end_course.service.image.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/admin/image")
public class ImageController {
    @Autowired
    private StorageService storageService;

    @PostMapping
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        String uploadImage = storageService.uploadImage(file);
        return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
    }

    @GetMapping("/{fileName}")
    public ResponseEntity<?> download(@PathVariable String fileName) {
        byte[] imageData = storageService.downloadImage(fileName);

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageData);
    }

    @GetMapping("/{id}/get")
    public ResponseEntity<?> load(@PathVariable Long id) {
        byte[] imageData = storageService.loadImageById(id);
//        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageData);
        return new ResponseEntity<>("heyehey", HttpStatus.OK);

    }

}
