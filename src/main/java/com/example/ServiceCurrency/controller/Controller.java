package com.example.ServiceCurrency.controller;


import com.example.ServiceCurrency.model.CourseGetResponse;
import com.example.ServiceCurrency.service.CourseService;
import com.example.ServiceCurrency.service.GifService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;


@RestController
@AllArgsConstructor
@NoArgsConstructor
public class Controller {

    // CONFIGURATION VARIABLES
    @Value("${courses.appId}")
    private String appId;
    @Value("${courses.base}")
    private String base;
    @Value("${gifs.apiKey}")
    private String apiKey;
    private int offset;

    @Autowired
    CourseService courseService;

    @Autowired
    GifService gifService;

    // START SERVICE
    @GetMapping(value = "/api/{symbols}")
    public ResponseEntity startService(@PathVariable("symbols") String symbols) {
        try {
            if (compareCourses(symbols)) {

                return ResponseEntity.ok(gif(apiKey, "rich", 1, (int)(1+Math.random() * 100)));

            } else if (!compareCourses(symbols)) {

                return ResponseEntity.ok(gif(apiKey, "broke", 1, (int)(1+Math.random() * 100)));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
    }

    // COMPARISON OF EXCHANGE RATES

    @GetMapping("/{date}.json")
    public CourseGetResponse course(@PathVariable("date") String date,
                                    @RequestParam("app_id") String appId,
                                    @RequestParam("base") String base,
                                    @RequestParam("symbols") String symbol) {
        return courseService.getCourse(date, appId, base, symbol);
    }


    private boolean compareCourses(String symbols) throws Exception {
        LocalDate now = LocalDate.now();
        CourseGetResponse courseNow = course(now.toString(), appId, base, symbols);
        CourseGetResponse courseYesterday = course(now.minusDays(1).toString(), appId, base, symbols);
        return courseNow.getRates().get(symbols) >= courseYesterday.getRates().get(symbols);
    }

    // GET GIF BY COURSE
    @GetMapping("/search")
    private String gif(@RequestParam("api_key") String appKey,
                       @RequestParam("q") String q,
                       @RequestParam("limit") int limit,
                       @RequestParam("offset") int offset) {
        String response = gifService.getGif(appKey, q, 1, offset);
        JSONObject obj = new JSONObject(response);
        var arr = obj.getJSONArray("data");
        String urlGif = arr.getJSONObject(0).getJSONObject("images").getJSONObject("original").getString("url");
        return urlGif;
    }
}
