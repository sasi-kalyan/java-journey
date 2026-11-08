package tutorial.spring.security.demo.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tutorial.spring.security.demo.dto.UserObj;
import tutorial.spring.security.demo.repository.UserObjRepository;

import java.util.Optional;

@Service
public class UserObjService implements UserDetailsService {

    private PasswordEncoder passwordEncoder;
    private UserObjRepository userObjRepository;

    public UserObjService(PasswordEncoder passwordEncoder, UserObjRepository userObjRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userObjRepository = userObjRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserObj> userObj = userObjRepository.findByUsername(username);
        UserObj userObj1 = userObj.get();

        UserDetails userDetails = User.builder()
                .username(userObj1.getUsername())
                .password(userObj1.getPassword())
                .roles(userObj1.getRole())
                .build();

        return userDetails;
    }

    public UserObj createUser(UserObj userObj){

        UserObj userObj1 = new UserObj();
        userObj1.setId(userObj.getId());
        userObj1.setUsername(userObj.getUsername());
        userObj1.setPassword(passwordEncoder.encode(userObj.getPassword()));
        userObj1.setRole(userObj.getRole());

        userObjRepository.save(userObj1);

        return userObj1;
    }
}
