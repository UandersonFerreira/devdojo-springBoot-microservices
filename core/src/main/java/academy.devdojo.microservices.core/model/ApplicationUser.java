package academy.devdojo.microservices.core.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor//Construtor sem argumentos
@AllArgsConstructor//Construtor com todos os abritubos
@ToString
@EqualsAndHashCode
public class ApplicationUser implements AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include//Indica o(s) campo(s) usando na geração do equalsandhasCode será somente o 'id';
    private Long id;
    @NotNull(message = "The field 'username' is mandatory!!")
    @Column(nullable = false)
    private String username;
    @NotNull(message = "The field 'password' is mandatory!!")
    @Column(nullable = false)
    private String password;
    @NotNull(message = "The field 'role' is mandatory!!")
    @Column(nullable = false)
    private String role = "USER";//todos os usuários criados terão a role User.

    public ApplicationUser(@NotNull ApplicationUser applicationUser) {//O nome que se dar a esse tipod e construtor é Copy Constructor
        this.id = applicationUser.getId();
        this.username = applicationUser.username;
        this.password = applicationUser.password;
        this.role = applicationUser.role;
    }
}//class
