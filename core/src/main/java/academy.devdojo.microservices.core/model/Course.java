package academy.devdojo.microservices.core.model;

import lombok.*;
import org.hibernate.annotations.NotFound;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Course implements AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @NotNull(message = "The field 'title' is mandatory!!")
    @Column(nullable = false)
    private String title;

}
