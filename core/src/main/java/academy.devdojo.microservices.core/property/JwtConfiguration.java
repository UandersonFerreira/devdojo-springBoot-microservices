package academy.devdojo.microservices.core.property;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "jwt.config")//Todo atributo definido aqui terá esse prefixo no começo
@Getter
@Setter
@ToString
public class JwtConfiguration {
    private String loginUrl = "/login/**";

    @NestedConfigurationProperty
    private Header header =  new Header();
    private int expiration = 3600;
    private String privateKey = "ZUOsVgUojq3s01SFM8kB0z0qSnTFrFGg";
    private String type = "encrypted";
   @Getter
   @Setter
    public static class Header{
       private String name = "Authorization";//Nome do header que têm o token
       private String prefix = "Bearer ";
    }
}//class
