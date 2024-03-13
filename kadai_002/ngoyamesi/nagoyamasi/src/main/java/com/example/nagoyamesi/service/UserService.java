package com.example.nagoyamesi.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.nagoyamesi.entity.Role;
import com.example.nagoyamesi.entity.User;
import com.example.nagoyamesi.form.SignupForm;
import com.example.nagoyamesi.repository.RoleRepository;
import com.example.nagoyamesi.repository.UserRepository;

@Service
public class UserService {
	 private final UserRepository userRepository;
     private final RoleRepository roleRepository;
     private final PasswordEncoder passwordEncoder;
     
     public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
         this.userRepository = userRepository;
         this.roleRepository = roleRepository;        
         this.passwordEncoder = passwordEncoder;
     }    
     
     @Transactional
     public User create(SignupForm signupForm) {
         User user = new User();
         Role role = roleRepository.findByName("ROLE_GENERAL");
         
         user.setName(signupForm.getName());
         user.setFurigana(signupForm.getFurigana());
         user.setAge(signupForm.getAge());
         user.setPostCode(signupForm.getPostCode());
         user.setAddress(signupForm.getAddress());
         user.setTelephoneNumber(signupForm.getTelephoneNumber());
         user.setEmailAddress(signupForm.getEmailAddress());
         user.setPassword(passwordEncoder.encode(signupForm.getPassword()));
         user.setRole(role);
         user.setEnabled(true);        
         
         return userRepository.save(user);
     }    
     
     // メールアドレスが登録済みかどうかをチェックする
     public boolean isEmailRegistered(String emailAddress) {
         User user = userRepository.findByEmailAddress(emailAddress);  
         return user != null;
     }
     
     // パスワードとパスワード（確認用）の入力値が一致するかどうかをチェックする
     public boolean isSamePassword(String password, String passwordConfirmation) {
         return password.equals(passwordConfirmation);
     } 
}
