package com.projet.FileManagement.models;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class LoginForm {
    @NotNull
    //@Size(min=3, max = 60)
    private String username;

    @NotNull
   // @Size(min = 6, max = 40)
    private String password;
}