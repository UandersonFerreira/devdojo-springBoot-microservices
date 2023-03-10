package academy.devdojo.microservices.auth.security.user;

import academy.devdojo.microservices.core.model.ApplicationUser;
import academy.devdojo.microservices.core.repository.ApplicationUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class UserDetailsServiceImplementations implements UserDetailsService {
    private final ApplicationUserRepository applicationUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Searching in the DB the user by username '{}'", username);

        ApplicationUser applicationUser = applicationUserRepository.findByUsername(username);
        log.info("ApplicationUser found '{}'", applicationUser);
        if (applicationUser == null){
            throw  new UsernameNotFoundException(String.format("Application user '%s' not found", username));
        }
        return new CustomUserDetails(applicationUser);
    }

    private static final class CustomUserDetails extends ApplicationUser implements UserDetails{
        public CustomUserDetails(@NotNull ApplicationUser applicationUser) {
            super(applicationUser);
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            List<GrantedAuthority> authorityList = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_" + this.getRole());
            return authorityList;
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }


}//class
