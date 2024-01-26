package com.pegien.HighSchoolExamination.Users.enums;

import org.springframework.security.core.GrantedAuthority;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public enum UserRoles implements GrantedAuthority {
    ADMIN(new HashSet<>(Set.of("user:read", "user:write","logs:view"))),
    HOD(new HashSet<>(Set.of("subject:read", "subject:write"))),
    PRINCIPAL(new HashSet<>(Set.of("student:read", "student:write","student:register"))),

    SECRETARY(new HashSet<>(Set.of("sms:balance","sms:send","sms:read")));





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


    public static HashMap<UserRoles, Set<String>> listAllRoles()
    {
        HashMap<UserRoles,Set<String>> all= new HashMap<>();
        for(UserRoles r:UserRoles.values())
        {
            all.put(r,r.getPermissions());
        }
        return all;
    }

}
