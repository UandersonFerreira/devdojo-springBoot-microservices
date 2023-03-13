package academy.devdojo.microservices.core.repository;


import academy.devdojo.microservices.core.model.ApplicationUser;
import academy.devdojo.microservices.core.model.Course;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ApplicationUserRepository extends PagingAndSortingRepository<ApplicationUser, Long> {
    public ApplicationUser findByUsername(String username);

}
