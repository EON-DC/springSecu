package com.example.demo.member;

import com.example.demo.auth.ApplicationUserRole;
import lombok.Getter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String email;

    @Enumerated(EnumType.STRING)
    private ApplicationUserRole role;

    public Member() {
    }

    public Member(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = ApplicationUserRole.USER;
    }

    //== 비즈니스 메서드 ==//
    // 비밀번호 암호화
    public void encodingPassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.getPassword());
    }

    // 권한 변경
    public Member roleToAdmin() {
        this.role = ApplicationUserRole.ADMIN;
        return this;
    }
}
