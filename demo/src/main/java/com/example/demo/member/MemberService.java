package com.example.demo.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    public void saveMember(Member member) {
        member.encodingPassword(passwordEncoder);
        memberRepository.save(member);

        //todo : 같은 유저네임 중복 방지 로직 추가
    }

    public Member findById(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(() -> new IllegalStateException("can't found userId : " + memberId));
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }


}
