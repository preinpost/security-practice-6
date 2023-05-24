package hello.demo.security;

import hello.demo.repository.UserRepository;
import hello.demo.entity.User;
import hello.demo.security.userdetails.CustomUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Slf4j
@Service
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public JpaUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Supplier<UsernameNotFoundException> s = () -> new UsernameNotFoundException("Problem during authentication!");

        log.info("JpaUserDetailsService.loadUserByUsername");
        log.info("username = {}", username);

        User u = userRepository
                .findUserByUsername(username)
                .orElseThrow(s);

        log.info("JpaUserDetailsService.loadUserByUsername#END");

        return new CustomUserDetails(u);
    }
}