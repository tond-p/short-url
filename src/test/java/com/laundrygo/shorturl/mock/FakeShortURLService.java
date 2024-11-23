package com.laundrygo.shorturl.mock;

import com.laundrygo.shorturl.common.enums.Errors;
import com.laundrygo.shorturl.common.exception.BaseNotFoundException;
import com.laundrygo.shorturl.url.domain.URLMapping;
import com.laundrygo.shorturl.url.service.ShortURLService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class FakeShortURLService implements ShortURLService {

    private final List<URLMapping> data = Collections.synchronizedList(new ArrayList<>());

    @Override
    public Optional<URLMapping> findByOriginUrl(String originUrl) {
        return data.stream()
            .filter(data -> data.getOriginUrl().equals(originUrl))
            .findAny();
    }

    @Override
    public URLMapping getByShortUrlThrowIfNotExist(String shortUrl) {
        return data.stream()
            .filter(data -> data.getShortUrl().equals(shortUrl))
            .findAny()
            .orElseThrow(() -> new BaseNotFoundException(Errors.NOT_FOUND_URL_MAPPING));
    }

    @Override
    public void save(URLMapping shortUrl) {
        data.add(shortUrl);
    }

}
