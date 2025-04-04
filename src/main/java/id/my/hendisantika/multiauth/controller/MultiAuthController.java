package id.my.hendisantika.multiauth.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-multi-auth
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 04/04/25
 * Time: 07.15
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@RestController
@RequestMapping("/api/multi-auth")
public class MultiAuthController {

    @GetMapping("/server/test")
    public String serverTestEndpoint() {
        log.info("This is a secured endpoint! You have successfully authenticated using an API key.");
        return "This is a secured endpoint! You have successfully authenticated using an API key.";
    }

    @GetMapping("/client/test")
    public String clientTestEndpoint(Principal principal) {
        log.info("This is a secured endpoint for clients! You are authenticated as: {}", principal.getName());
        return "This is a secured endpoint for clients! You are authenticated as: " + principal.getName();
    }
}
