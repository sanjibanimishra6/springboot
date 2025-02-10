package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FruitController {
    private final AtomicLong atomicLong = new AtomicLong();

    @GetMapping("/fruits")
    public Fruits fruits(
            @RequestParam(value = "fruit_name", defaultValue = "Mango") String fruitName,
            @RequestParam(value = "season", defaultValue = "Summer") String season) {
        return new Fruits(atomicLong.incrementAndGet(), fruitName, season);
    }
}
