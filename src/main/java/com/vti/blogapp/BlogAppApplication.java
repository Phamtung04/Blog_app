package com.vti.blogapp;

import com.vti.blogapp.entity.Role;
import com.vti.blogapp.entity.User;
import com.vti.blogapp.repository.RoleRepository;
import com.vti.blogapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
@AllArgsConstructor
public class BlogAppApplication implements CommandLineRunner {
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var user = new User();
		user.setName("Nguyen Van Khoa");
		user.setUsername("khoa.vn");
		user.setEmail("khoa.vn@gmail.com");
		var encodedPassword = passwordEncoder.encode("admin");
		user.setPassword(encodedPassword);
		var admin = roleRepository.findByType(Role.Type.ADMIN);
		var employee = roleRepository.findByType(Role.Type.EMPLOYEE);
		var roles = Set.of(admin, employee);
		user.setRoles(roles);
		userRepository.save(user);
 	}
}
