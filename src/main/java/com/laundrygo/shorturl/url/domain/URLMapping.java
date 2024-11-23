package com.laundrygo.shorturl.url.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "url_mapping", uniqueConstraints = {
        @UniqueConstraint(name = "u_origin_url", columnNames = {"origin_url"})})
public class URLMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "origin_url")
    private String originUrl;

    @Column(name = "short_url")
    private String shortUrl;

    @Column(name = "req_count")
    private Long requestCount;

    @Builder
    private URLMapping(String originUrl, String shortUrl, long requestCount) {
        this.originUrl = originUrl;
        this.shortUrl = shortUrl;
        this.requestCount = requestCount;
    }

    public static URLMapping of(String originUrl, String shortUrl) {
        return URLMapping.builder()
            .originUrl(originUrl)
            .shortUrl(shortUrl)
            .requestCount(1)
            .build();
    }

    public void addRequestCount() {
        this.requestCount++;
    }

}
