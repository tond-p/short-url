package com.laundrygo.shorturl.url.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import com.laundrygo.shorturl.common.exception.BaseNotFoundException;
import com.laundrygo.shorturl.mock.FakeShortURLGenerator;
import com.laundrygo.shorturl.mock.FakeShortURLService;
import com.laundrygo.shorturl.url.domain.URLMapping;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

class ShortUrlFacadeTest {

    private ShortURLFacade facade;
    private static final String BASE_URL = "http://short.url/";

    @BeforeEach
    void setup() {
        FakeShortURLGenerator generator = new FakeShortURLGenerator("Abedf257");
        FakeShortURLService service = new FakeShortURLService();
        facade = new ShortURLFacade(generator, service);

        service.save(
            URLMapping.of("http://example.com", "Abedf257")
        );

        // Reflection으로 BASE_URL 필드 설정
        ReflectionTestUtils.setField(facade, "BASE_URL", BASE_URL);
    }

    @Test
    void Short_URL을_생성한다() {
        //given
        String originUrl = "http://example.com";

        //when
        String shortUrl = facade.originToShort(originUrl);

        //then
        assertThat(shortUrl).isEqualTo("http://short.url/Abedf257");
    }

    @Test
    void Origin_URL을_반환한다() {
        //given
        String shortUrl = "http://short.url/Abedf257";

        //when
        String originUrl = facade.shortToOrigin(shortUrl);

        //then
        assertThat(originUrl).isEqualTo("http://example.com");
    }

    @Test
    void Origin_URL이_존재하지_않는경우_404를_반환한다() {
        //given
        //when
        String shortUrl = "http://short.url/cc77ddd";

        //then
        assertThatThrownBy(() -> {
            facade.shortToOrigin(shortUrl);
        }).isInstanceOf(BaseNotFoundException.class);
    }

}