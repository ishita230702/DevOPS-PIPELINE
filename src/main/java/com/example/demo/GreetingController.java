package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class GreetingController {

    @GetMapping("/")
    public String greetUser(@RequestParam(value = "name", defaultValue = "World") String name) {
        String currentTime = getCurrentTime();
        String weatherInfo = getWeatherInfo();
        
        return generateHtmlResponse(name, currentTime, weatherInfo);
    }

    private String getCurrentTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }

    private String getWeatherInfo() {
        // Mock weather data
        return "Sunny, 25°C";
    }

    private String generateHtmlResponse(String name, String currentTime, String weatherInfo) {
        return "<!DOCTYPE html>" +
               "<html>" +
               "<head>" +
               "<title>Greeting Page</title>" +
               "<style>" +
               "body { font-family: Arial, sans-serif; background-color: #f0f8ff; text-align: center; padding: 50px; }" +
               "h1 { color: #333; }" +
               ".info { font-size: 1.2em; margin-top: 20px; }" +
               ".weather { font-size: 1.1em; margin-top: 10px; color: #007BFF; }" +
               "</style>" +
               "</head>" +
               "<body>" +
               "<h1>Hello " + name + "!</h1>" +
               "<div class='info'>Current server time is: " + currentTime + "</div>" +
               "<div class='weather'>Weather: " + weatherInfo + "</div>" +
               "</body>" +
               "</html>";
    }
}
