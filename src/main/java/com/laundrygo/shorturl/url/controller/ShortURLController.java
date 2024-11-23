package com.laundrygo.shorturl.url.controller;

import com.laundrygo.shorturl.url.service.ShortURLFacade;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/short-url")
public class ShortURLController {

    private final ShortURLFacade facade;

    @PostMapping
    public String createShortUrl(@RequestParam @NotNull String originUrl) {
        return facade.originToShort(originUrl);
    }

    @GetMapping
    public String getOriginalUrl(@RequestParam @NotNull String shortUrl) {
        return facade.shortToOrigin(shortUrl);
    }

}
