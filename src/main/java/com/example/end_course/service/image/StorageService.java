package com.example.end_course.service.image;

import com.example.end_course.model.ImageData;
import com.example.end_course.repository.StorageRepository;
import com.example.end_course.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class StorageService {
    @Autowired
    private StorageRepository storageRepository;

    public String uploadImage(MultipartFile file) throws IOException {
        ImageData imageData =  storageRepository.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build());
        if (imageData != null) {
            return "file uploaded successfully " + file.getOriginalFilename();
        }
        return null;
    }

    public byte[] downloadImage(String fileName) {
        Optional<ImageData> dbImageData = storageRepository.findByName(fileName);
        byte[] image = ImageUtils.decompressImage(dbImageData.get().getImageData());
        return image;
    }

    public byte[] loadImageById(long id) {
        Optional<ImageData> dbImageData = storageRepository.findById(id);
        byte[] image = ImageUtils.decompressImage(dbImageData.get().getImageData());
        return image;
    }
}
