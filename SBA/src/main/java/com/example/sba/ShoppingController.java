package com.example.sba;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ShoppingController {
	private final AtomicLong atomicLong = new AtomicLong();

    @GetMapping("/shopping")
    public Shopping shopping(
            @RequestParam(value = "outfitname", defaultValue = "Dress") String outfitname,
            @RequestParam(value = "gender", defaultValue = "Women") String gender) {
        return new Shopping(atomicLong.incrementAndGet(), outfitname, gender);
    }
}
