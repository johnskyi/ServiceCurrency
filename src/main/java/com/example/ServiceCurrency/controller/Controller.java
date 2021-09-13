package com.example.ServiceCurrency.controller;


import com.example.ServiceCurrency.model.Course;
import com.example.ServiceCurrency.model.Gif;
import com.example.ServiceCurrency.service.CourseService;
import com.example.ServiceCurrency.service.GifService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    CourseService courseService;

    @Autowired
    GifService gifService;
    @RequestMapping("/")
    public String homePage()
    {
        return LocalDate.now().toString() + "\n ServiceCurrency";
    }


    // START SERVICE

    @GetMapping(value = "/api/{symbols}", produces = "application/json")
    public Gif startService(@PathVariable("symbols") String symbols) {

            if (compareCourses(symbols)) {

                return gif(apiKey, "rich", 25, 0);

            } else {

                return gif(apiKey, "broke", 25, 0);
            }
    }

    // COMPARISON OF EXCHANGE RATES

    @GetMapping("/{date}.json")
    public Course course(@PathVariable("date") String date,
                         @RequestParam("app_id") String appId,
                         @RequestParam("base") String base,
                         @RequestParam("symbols") String symbol) {
        return courseService.getCourse(date, appId, base, symbol);
    }


    public boolean compareCourses(String symbols){
        LocalDate now = LocalDate.now();
        Course courseNow = course(now.toString(), appId, base, symbols);
        Course courseYesterday = course(now.minusDays(1).toString(), appId, base, symbols);
        return courseNow.getRates().get(symbols) >= courseYesterday.getRates().get(symbols);
    }

    // GET GIF BY COURSE
    @GetMapping("/search")
    public Gif gif(@RequestParam("api_key") String appKey,
                       @RequestParam("q") String q,
                       @RequestParam("limit") int limit,
                       @RequestParam("offset") int offset) {
        String response = gifService.getGif(appKey, q, 25, 0);
        JSONObject obj = new JSONObject(response);
        var arr = obj.getJSONArray("data");
        int random = (int) (1 + Math.random() * 23);
        String urlGif = arr.getJSONObject(random).getJSONObject("images").getJSONObject("original").getString("url");
        Gif gif = new Gif();
        gif.setUrl(urlGif);
        return gif;
    }
}
