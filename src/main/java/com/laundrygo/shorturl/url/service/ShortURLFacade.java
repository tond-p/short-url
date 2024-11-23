package com.laundrygo.shorturl.url.service;

import com.laundrygo.shorturl.url.domain.URLMapping;
import com.laundrygo.shorturl.url.service.port.ShortURLGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShortURLFacade {

    private final ShortURLGenerator generator;
    private final ShortURLService service;

    @Value("${server.base-url}")
    private String BASE_URL;

    public String originToShort(final String originUrl) {
        return service.findByOriginUrl(originUrl)
            .map(shortUrl -> {
                shortUrl.addRequestCount();
                return prependBaseUrl(shortUrl.getShortUrl());
            })
            .orElseGet(() -> {
                final String encodedUrl = generator.encode();
                service.save(URLMapping.of(originUrl, encodedUrl));
                return prependBaseUrl(encodedUrl);
            });
    }

    public String shortToOrigin(final String shortUrl) {
        return service.getByShortUrlThrowIfNotExist(stripBaseUrl(shortUrl))
            .getOriginUrl();
    }

    private String prependBaseUrl(String encodedUrl) {
        return String.format("%s%s", BASE_URL, encodedUrl);
    }

    private String stripBaseUrl(String url) {
        return url.replaceAll(BASE_URL, "");
    }

}
