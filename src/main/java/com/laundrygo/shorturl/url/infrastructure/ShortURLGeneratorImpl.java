package com.laundrygo.shorturl.url.infrastructure;

import com.laundrygo.shorturl.url.service.port.ShortURLGenerator;
import de.huxhorn.sulky.ulid.ULID;
import java.math.BigInteger;
import org.springframework.stereotype.Component;

@Component
public class ShortURLGeneratorImpl implements ShortURLGenerator {

    private static final String BASE62_CHARACTERS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int BASE62 = BASE62_CHARACTERS.length();
    private static final ULID ulidGenerator = new ULID();;

    @Override
    public String encode() {
        StringBuilder sb = new StringBuilder();
        ULID.Value ulidValue = ulidGenerator.nextValue();
        final long timestamp = ulidValue.timestamp();

        BigInteger num = BigInteger.valueOf(timestamp);
        while (num.compareTo(BigInteger.ZERO) > 0) {
            BigInteger remainder = num.mod(BigInteger.valueOf(BASE62));
            sb.append(BASE62_CHARACTERS.charAt(remainder.intValue()));
            num = num.divide(BigInteger.valueOf(BASE62));
        }
        return sb.reverse().toString();
    }

}
