package academy.devdojo.microservices.core.model;

import lombok.*;
import org.hibernate.annotations.NotFound;

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
public class Course implements AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include//Indica o(s) campo(s) usando na geração do equalsandhasCode será somente o 'id';
    private Long id;
    @NotNull(message = "The field 'title' is mandatory!!")
    @Column(nullable = false)
    private String title;

}
