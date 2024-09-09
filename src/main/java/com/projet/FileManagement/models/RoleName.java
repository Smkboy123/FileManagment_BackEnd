package com.projet.FileManagement.models;

import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Arrays;

@ToString
@NoArgsConstructor
public enum RoleName {

    ROLE_ADMIN(Name.ROLE_ADMIN), ROLE_USER(Name.ROLE_USER), UNKNOWN(Name.UNKNOWN);

    private String value;

    RoleName(String value) {
        this.value = value;
    }

    public static RoleName of(String value) {

        return Arrays.stream(RoleName.values())
                .filter(p -> p.value.equals(value))
                .findFirst()
                .orElse(UNKNOWN);
    }

    public String getValue() {
        return value;
    }

    public class Name {
        public static final String ROLE_ADMIN = "ROLE_ADMIN";
        public static final String ROLE_USER = "ROLE_USER";
        public static final String UNKNOWN = "UNKNOWN";
        private Name() {
        }
    }

    }
