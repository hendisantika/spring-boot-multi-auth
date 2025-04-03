package id.my.hendisantika.multiauth.service;

import id.my.hendisantika.multiauth.config.ApiKeyAuthentication;
import id.my.hendisantika.multiauth.config.AuthenticationApi;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-multi-auth
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 04/04/25
 * Time: 06.50
 * To change this template use File | Settings | File Templates.
 */
@Service
public class AuthenticationService {

    /**
     * The name of the HTTP header containing the API Key.
     */
    public static final String AUTH_TOKEN_HEADER_NAME = "API-KEY";

    /**
     * Attempts to retrieve and validate the API Key from the request header.
     * If valid, it creates an Authentication object representing the API Key.
     *
     * @param request the HttpServletRequest object
     * @return an Authentication object containing the validated API Key, or throws an exception if invalid
     * @throws BadCredentialsException if the API Key is missing or invalid
     */
    public static Authentication getAuthentication(HttpServletRequest request) {
        String apiKey = request.getHeader(AUTH_TOKEN_HEADER_NAME);
        if (apiKey == null || !apiKey.equals("12345abc")) {
            throw new BadCredentialsException("Invalid API Key");
        }

        return new ApiKeyAuthentication(apiKey, AuthorityUtils.NO_AUTHORITIES);
    }

    public AuthenticationApi createRetrofitService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("YOUR REST ENDPOINT URL GOES HERE")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        return retrofit.create(AuthenticationApi.class);
    }
}
