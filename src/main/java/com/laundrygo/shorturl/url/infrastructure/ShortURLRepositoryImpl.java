package com.laundrygo.shorturl.url.infrastructure;

import com.laundrygo.shorturl.url.domain.URLMapping;
import com.laundrygo.shorturl.url.service.port.ShortURLRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ShortURLRepositoryImpl implements ShortURLRepository {

    private final ShortURLJpaRepository jpaRepository;

    @Override
    public Optional<URLMapping> findByOriginUrl(String originUrl) {
        return jpaRepository.findByOriginUrl(originUrl);
    }

    @Override
    public Optional<URLMapping> findByShortUrl(String shortUrl) {
        return jpaRepository.findByShortUrl(shortUrl);
    }

    @Override
    public void save(URLMapping shortUrl) {
        jpaRepository.save(shortUrl);
    }
}
