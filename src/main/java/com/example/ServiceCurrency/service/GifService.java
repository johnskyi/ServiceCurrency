package com.example.ServiceCurrency.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//https://api.giphy.com/v1/gifs/search?api_key=6QAt1H7Flq17tOOpChp3wVx3Wtoudri1&q=rich&limit=1&offset=2

@FeignClient(name = "gifs", url="${gifs.urlGifs}")
public interface GifService {

    @GetMapping("/search")
    String getGif(@RequestParam("api_key") String appKey,
                          @RequestParam("q") String q,
                          @RequestParam("limit") int limit,
                          @RequestParam("offset") int offset);
}
