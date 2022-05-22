package cloud.autotests.config;

import org.aeonbits.owner.Config;
@Config.Sources("classpath:config/loginPass.properties")
public interface LoginConfig extends Config {
    String baseUrl();
    String userLogin();
    String userPassword();

}
