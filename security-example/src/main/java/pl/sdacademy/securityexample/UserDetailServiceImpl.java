package pl.sdacademy.securityexample;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    // private List<User> users = Arrays.asList(
    //         new User("arqarq", "pass1"),
    //         new User("user2", "pass2"),
    //         new User("user3", "pass3")
    // );
    private UserRepository userRepository;

    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // return users.stream()
        //         .filter(user -> username.equals(user.getUsername()))
        //         .findFirst()
        //         .orElseThrow(() -> new UsernameNotFoundException("No such user: " + username));
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("No such user: " + username));
    }
}
