package com.laundrygo.shorturl.url.service;

import com.laundrygo.shorturl.common.enums.Errors;
import com.laundrygo.shorturl.common.exception.BaseNotFoundException;
import com.laundrygo.shorturl.url.domain.URLMapping;
import com.laundrygo.shorturl.url.service.port.ShortURLRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ShortURLServiceImpl implements ShortURLService {

    private final ShortURLRepository repository;

    @Transactional(readOnly = true)
    public Optional<URLMapping> findByOriginUrl(String originUrl) {
        return repository.findByOriginUrl(originUrl);
    }

    @Transactional(readOnly = true)
    public URLMapping getByShortUrlThrowIfNotExist(String shortUrl) {
        return repository.findByShortUrl(shortUrl)
            .orElseThrow(() -> new BaseNotFoundException(Errors.NOT_FOUND_URL_MAPPING));
    }

    @Transactional
    public void save(URLMapping shortUrl) {
        repository.save(shortUrl);
    }

}
