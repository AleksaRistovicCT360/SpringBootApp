package com.example.springbootapp.appuser;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND = "user with username %s not found";

    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUserRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException(String.format(USER_NOT_FOUND, username)));
    }

    public String signUpUser(AppUser appUser) {
        boolean userExist = appUserRepository.findByUsername(appUser.getUsername()).isPresent();

        if (userExist) {
            throw new IllegalStateException("username already taken");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());

        appUser.setPassword(encodedPassword);
        appUser.setAppUserRole(appUser.getAppUserRole());

        appUserRepository.save(appUser);

        return "Saved app user";
    }
}
