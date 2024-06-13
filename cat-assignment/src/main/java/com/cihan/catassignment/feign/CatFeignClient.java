package com.cihan.catassignment.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "catWS", url = "${cataas.url}")
public interface CatFeignClient {

    @GetMapping(value = "/cat/{tag}", produces = "image/*")
    byte[] getCatByTag(@PathVariable String tag);

    @GetMapping(value = "/cat/says/{text}", produces = "image/*")
    byte[] getCatByText(@PathVariable String text);

    @GetMapping(value = "/cat", produces = "image/*")
    byte[] getCatByDimensions(@RequestParam("width") int width, @RequestParam("height") int height);
}
