package com.cihan.catassignment.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "catWS", url = "${cataas.url}")
public interface CatFeignClient {


//    @RequestMapping(method = RequestMethod.GET, value = "/cat/{tag}?position=center&html=true")
//    String getCatByTag(@PathVariable String tag);

//    @RequestMapping(method = RequestMethod.GET, value = "/cat/says/{text}?font=Impact&fontSize=30&fontColor=%23000&fontBackground=none&position=center&html=true")
//    String getCatWithText(@PathVariable String text);
//
//    @RequestMapping(method = RequestMethod.GET, value = "/cat?position=center&html=true")
//    String getRandomCatWithDimensions(@RequestParam(value = "width") int width, @RequestParam(value = "height" ) int height);

    @GetMapping(value = "/cat/{tag}", produces = "image/*")
    byte[] getCatByTag(@PathVariable String tag);

    @GetMapping(value = "/cat/says/{text}", produces = "image/*")
    byte[] getCatByText(@PathVariable String text);

    @GetMapping(value = "/cat", produces = "image/*")
    byte[] getCatByDimensions(@RequestParam("width") int width, @RequestParam("height") int height);
}
