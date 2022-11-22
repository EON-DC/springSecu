package com.example.demo.auth;

import com.example.demo.member.Member;
import com.example.demo.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorizationUserService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member findMember = memberRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("not found username: " + username));
        ApplicationUser applicationUser = new ApplicationUser(findMember);

        return applicationUser;
    }
}
