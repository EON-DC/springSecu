package com.example.demo;

import com.example.demo.member.Member;
import com.example.demo.member.MemberRepository;
import com.example.demo.student.Student;
import com.example.demo.student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository, MemberRepository memberRepository
	, PasswordEncoder passwordEncoder) {
		return args -> {
			memberRepository.save(new Member("linda", passwordEncoder.encode("1234"), "linda1@gmail.com").roleToAdmin());
			memberRepository.save(new Member("jake", passwordEncoder.encode("1234"), "jake12@gmail.com"));


			studentRepository.save(new Student("park", "math"));
			studentRepository.save(new Student("Yun", "science"));
			studentRepository.save(new Student("Woong", "language"));
			studentRepository.save(new Student("choi", "english"));
			studentRepository.save(new Student("sing", "france"));
			studentRepository.save(new Student("lee", "japan"));

		};
	}

}
