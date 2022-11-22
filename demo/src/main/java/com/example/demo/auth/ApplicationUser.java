package com.example.demo.auth;

import com.example.demo.member.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class ApplicationUser implements UserDetails {

    private final Member member;

    public ApplicationUser(Member member) {
        this.member = member;
    }
    @Override
    public String getUsername() {
        return member.getUsername();
    }

    @Override
    public String getPassword() {
        return member.getPassword();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return member.getRole().getSimpleGrantedAuthorities();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
