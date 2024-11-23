package com.laundrygo.shorturl.mock;

import com.laundrygo.shorturl.url.service.port.ShortURLGenerator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FakeShortURLGenerator implements ShortURLGenerator {

    private final String code;

    @Override
    public String encode() {
        return code;
    }

}
