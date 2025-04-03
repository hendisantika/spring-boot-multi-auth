package id.my.hendisantika.multiauth.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-multi-auth
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 04/04/25
 * Time: 06.49
 * To change this template use File | Settings | File Templates.
 */
@Setter
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class AuthenticationResponse<T> {
    List<Link> links = new ArrayList<>();
    private boolean success;
    private String message;
    private T data;
}
