package com.projet.FileManagement.models;

import com.sun.istack.NotNull;
import lombok.Data;

import java.util.Set;

@Data

public class RegisterForm {

    private String telephone;


    private String email;

    /// @NotNull
    private Set<String> role;

    @NotNull
    private String username;

    @NotNull
    private String password;
}
