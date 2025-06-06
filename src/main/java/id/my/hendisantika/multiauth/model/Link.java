package id.my.hendisantika.multiauth.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    private String path;
    private String rel;
}
