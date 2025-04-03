package id.my.hendisantika.multiauth.config;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

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
public interface AuthenticationApi {
    @GET("user/basic/")
    Call<AuthenticationResponse<UserResource>> authenticateUser(@Query("email") String email, @Query("password") String password);
}
