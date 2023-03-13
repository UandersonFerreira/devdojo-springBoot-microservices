package academy.devdojo.microservices.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan({"academy.devdojo.microservices.core.model"})// especificar quais pacotes queremos verificar para classes de entidade
@EnableJpaRepositories({"academy.devdojo.microservices"})
public class SpringBootMicroservicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMicroservicesApplication.class, args);
    }

}

/*
A anotação @EntityScan é usada quando as classes de
entidade não são colocadas no pacote principal do
aplicativo ou seus subpacotes. Ou seja,é quando usa
um pacote de raiz completamente diferente.
ex: Course.java está dentro do modulo 'core', mas está sendo usada em
CourseController.java que está dentro do modulo 'spring-boot-microservices'.


Devemos estar cientes de que o uso do EntityScan
desativará a verificação de configuração automática do
Spring Boot para entidades.
 */