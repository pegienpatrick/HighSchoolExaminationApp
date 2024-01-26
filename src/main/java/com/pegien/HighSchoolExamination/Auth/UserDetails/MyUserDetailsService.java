package com.pegien.HighSchoolExamination.Auth.UserDetails;

import com.pegien.HighSchoolExamination.Users.User;
import com.pegien.HighSchoolExamination.Users.UserRepository;
import com.pegien.HighSchoolExamination.Utils.ConvertionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Long num= ConvertionUtils.getLong(username.trim());
        Optional<User> usr=userRepository.findById(num);
        if(usr.isEmpty())
            throw new UsernameNotFoundException("User Not Found");

        User user=usr.get();

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
