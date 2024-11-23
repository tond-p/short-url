package com.laundrygo.shorturl.url.service;

import com.laundrygo.shorturl.url.domain.URLMapping;
import java.util.Optional;

public interface ShortURLService {

    Optional<URLMapping> findByOriginUrl(String originUrl);

    URLMapping getByShortUrlThrowIfNotExist(String shortUrl);

    void save(URLMapping shortUrl);
}
