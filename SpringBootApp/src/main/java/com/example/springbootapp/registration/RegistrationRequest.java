package com.example.springbootapp.registration;

import com.example.springbootapp.appuser.AppUserRole;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String username;
    private final String password;
    private final AppUserRole appUserRole;
}
