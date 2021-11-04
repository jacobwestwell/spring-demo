package com.concept.concept;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Random;

@RestController
public class Controller {

    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/date")
    public String getDate() {
        Date date = new Date();
        return "The current date is: <br>" + date.toString();
    }

    @GetMapping("/randomnumber")
    @ResponseBody
    public Integer getRandomNumber(@RequestParam Integer min, @RequestParam Integer max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    @GetMapping("/truerandomnumber")
    @ResponseBody
    public String getTrueRandomNumber(@RequestParam Integer min, @RequestParam Integer max) {
        ResponseEntity<String> response = restTemplate.getForEntity("https://www.random.org/integers/?num=1&min=" + min.toString() + "&max=" + max.toString() + "&col=1&base=10&format=plain", String.class);
        return response.getBody();
    }
}
