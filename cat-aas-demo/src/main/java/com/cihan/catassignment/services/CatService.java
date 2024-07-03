package com.cihan.catassignment.services;

import com.cihan.catassignment.domain.CatImage;
import com.cihan.catassignment.exceptions.GenException;
import com.cihan.catassignment.feign.CatFeignClient;
import com.cihan.catassignment.repositories.CatImageRepository;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class CatService {

    private final CatFeignClient catFeignClient;
    private final CatImageRepository catImageRepository;
    private final RestTemplate restTemplate;

    @Value("${file.storage.root-dir}")
    private String rootDir;

    public byte[] getCatByTag(String tag) {
        try {
            return catFeignClient.getCatByTag(tag);
        } catch (FeignException e) {
            if (e.status() == 404) {
                throw new GenException("Cat not found with tag: " + tag, e.status());
            }
            throw new GenException("Internal Server Error: " + e.getMessage(), e.status());
        }
    }

    public byte[] getCatByText(String text) {
        try {
            return catFeignClient.getCatByText(text);
        } catch (FeignException e) {
            if (e.status() == 404) {
                throw new GenException("Cat not found with text: " + text, e.status());
            }
            throw new GenException("Internal Server Error: " + e.getMessage(), e.status());
        }
    }

    public byte[] getCatByDimensions(int width, int height) {
        try {
            return catFeignClient.getCatByDimensions(width, height);
        } catch (FeignException e) {
            if (e.status() == 404) {
                throw new GenException("Cat not found with width: " + width + " and height: " + height, e.status());
            }
            throw new GenException("Internal Server Error: " + e.getMessage(), e.status());
        }
    }

    public CatImage downloadCatImage(byte[] imageBytes, String subFolder, String fileName) throws IOException {
        String fileExtension = ".jpeg";
        Path path = Paths.get(rootDir, subFolder, fileName + fileExtension);
        Files.createDirectories(path.getParent());
        Files.write(path, imageBytes);

        CatImage catImage = new CatImage();
        catImage.setFileName(fileName);
        catImage.setFilePath(path.toString());
        catImage.setFileSize(Files.size(path));

        return catImageRepository.save(catImage);
    }

}
