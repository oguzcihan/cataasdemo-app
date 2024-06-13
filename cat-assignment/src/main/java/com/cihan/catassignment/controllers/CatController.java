package com.cihan.catassignment.controllers;

import com.cihan.catassignment.domain.CatImage;
import com.cihan.catassignment.services.CatService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("api/cats")
public class CatController {

    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping("/tag")
    public ResponseEntity<byte[]> getCatByTag(@RequestParam String tag) {
        byte[] image = catService.getCatByTag(tag);
        return ResponseEntity.ok()
                .contentLength(image.length)
                .contentType(MediaType.IMAGE_JPEG)
                .body(image);
    }


    @GetMapping("/text")
    public ResponseEntity<byte[]> getCatByText(@RequestParam String text) {
        byte[] image = catService.getCatByText(text);
        return ResponseEntity.ok()
                .contentLength(image.length)
                .contentType(MediaType.IMAGE_JPEG)
                .body(image);
    }

    @GetMapping("/dimensions")
    public ResponseEntity<byte[]> getCatByDimensions(@RequestParam int width, @RequestParam int height) {
        byte[] image = catService.getCatByDimensions(width, height);
        return ResponseEntity.ok()
                .contentLength(image.length)
                .contentType(MediaType.IMAGE_JPEG)
                .body(image);
    }

    @PostMapping("/download")
    public ResponseEntity<CatImage> downloadCatImage(@RequestBody byte[] imageBytes, @RequestParam String subFolder, @RequestParam String fileName) {
        try {
            CatImage catImage = catService.downloadCatImage(imageBytes, subFolder, fileName);
            if (catImage != null) {
                return ResponseEntity.ok().body(catImage);
            }
            return ResponseEntity.notFound().build();
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
