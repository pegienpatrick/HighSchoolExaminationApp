package com.pegien.HighSchoolExamination.enums;

import org.springframework.security.core.GrantedAuthority;

import java.util.HashSet;
import java.util.Set;

public enum UserRoles implements GrantedAuthority {
    ADMIN(new HashSet<>(Set.of("user:read", "user:write"))),
    HOD(new HashSet<>(Set.of("subject:read", "subject:write"))),
    PRINCIPAL(new HashSet<>(Set.of("student:read", "student:write")));



    private final Set<String> permissions;

    UserRoles(Set<String> permissions) {
        this.permissions = permissions;
    }

    public Set<String> getPermissions() {
        return permissions;
    }


    @Override
    public String getAuthority() {
        return name();
    }
}
