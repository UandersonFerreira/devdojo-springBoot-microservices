package academy.devdojo.microservices.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan({"academy.devdojo.microservices.core.model"})
@EnableJpaRepositories({"academy.devdojo.microservices"})
public class SpringBootMicroservicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMicroservicesApplication.class, args);
    }

}
