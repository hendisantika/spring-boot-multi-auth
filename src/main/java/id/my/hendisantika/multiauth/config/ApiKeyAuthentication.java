package id.my.hendisantika.multiauth.config;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-multi-auth
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 04/04/25
 * Time: 06.46
 * To change this template use File | Settings | File Templates.
 */

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * An Authentication object representing an API Key for Spring Security.
 * Extends the AbstractAuthenticationToken class to provide a custom implementation
 * for API Key based authentication.
 */
public class ApiKeyAuthentication extends AbstractAuthenticationToken {

    private final String apiKey;

    /**
     * Creates a new ApiKeyAuthentication object with the provided API Key and authorities.
     *
     * @param apiKey      the API Key value obtained from the request header
     * @param authorities the collection of GrantedAuthority objects associated with the API Key,
     *                    typically an empty collection (e.g., AuthorityUtils.NO_AUTHORITIES)
     */
    public ApiKeyAuthentication(String apiKey, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.apiKey = apiKey;
        setAuthenticated(true);
    }

    /**
     * Returns null as credentials are not applicable for API Key authentication.
     *
     * @return null
     */
    @Override
    public Object getCredentials() {
        return null;
    }

    /**
     * Returns the API Key value as the principal object.
     *
     * @return the API Key string
     */
    @Override
    public Object getPrincipal() {
        return apiKey;
    }
}
