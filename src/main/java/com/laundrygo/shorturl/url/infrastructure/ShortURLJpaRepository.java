package com.laundrygo.shorturl.url.infrastructure;

import com.laundrygo.shorturl.url.domain.URLMapping;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortURLJpaRepository extends JpaRepository<URLMapping, Long> {

    Optional<URLMapping> findByOriginUrl(String originUrl);

    Optional<URLMapping> findByShortUrl(String shortUrl);

}
