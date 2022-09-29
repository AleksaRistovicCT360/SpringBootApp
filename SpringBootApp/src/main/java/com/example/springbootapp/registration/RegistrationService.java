package com.example.springbootapp.registration;

import com.example.springbootapp.appuser.AppUser;
import com.example.springbootapp.appuser.AppUserRole;
import com.example.springbootapp.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private final UsernameValidator usernameValidator;

    public String register(RegistrationRequest request) {
        boolean isValidUsername = usernameValidator.test(request.getUsername());

        if (!isValidUsername) {
            throw new IllegalStateException("username not valid");
        }
        return appUserService.signUpUser(
                new AppUser(
                        request.getUsername(),
                        request.getPassword(),
                        request.getAppUserRole()
                )
        );
    }
}
