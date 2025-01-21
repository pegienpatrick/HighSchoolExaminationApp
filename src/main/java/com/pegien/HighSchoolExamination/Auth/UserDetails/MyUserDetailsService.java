package com.pegien.HighSchoolExamination.Auth.UserDetails;

import com.pegien.HighSchoolExamination.Users.UsersHelpers.UserRoles.Utils.UserRoleUtils;
import com.pegien.HighSchoolExamination.Users.UsersHelpers.UserRoles.entity.UserRole;
import com.pegien.HighSchoolExamination.Users.UsersHelpers.UserRoles.repository.UserRolesRepository;
import com.pegien.HighSchoolExamination.Users.entity.User;
import com.pegien.HighSchoolExamination.Users.Repository.UserRepository;
import com.pegien.HighSchoolExamination.Users.enums.RolesCategory;
import com.pegien.HighSchoolExamination.Utils.ConvertionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRolesRepository userRolesRepository;

    @Override
    public MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Long num= ConvertionUtils.getLong(username.trim());
        Optional<User> usr=userRepository.findById(num);
        if(usr.isEmpty())
            throw new UsernameNotFoundException("User Not Found");

        User user=usr.get();
        if(user.getRolesCategory()==null)
        {
            if(user.getUsername().equalsIgnoreCase("admin"))
                user.setRolesCategory(RolesCategory.ADMIN);
            else
                user.setRolesCategory(RolesCategory.TEACHER);
            userRepository.saveAndFlush(user);
        }
        user.setRoles(
            UserRoleUtils.rolesMap.get(user.getRolesCategory())
        );

        List<UserRole> userRoles = userRolesRepository.findByUserId(user.getNum());
        for(UserRole r:userRoles)
            user.getRoles().add(r.getRoleName());

        HashSet<GrantedAuthority> authorities=new HashSet<>();
        if(user.getRoles()!=null) {
            for (String i : user.getRoles())
                authorities.add(new SimpleGrantedAuthority(i));
        }
        MyUserDetails myUserDetails= MyUserDetails.builder()
                .username(username)
                .password(user.getPassword())
                .authorities(authorities)
                .build();
        return myUserDetails;
    }
}
