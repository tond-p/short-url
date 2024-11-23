package com.laundrygo.shorturl.url.service.port;

import com.laundrygo.shorturl.url.domain.URLMapping;
import java.util.Optional;

public interface ShortURLRepository {

    Optional<URLMapping> findByOriginUrl(String originUrl);

    Optional<URLMapping> findByShortUrl(String ShortUrl);

    void save(URLMapping shortUrl);

}
