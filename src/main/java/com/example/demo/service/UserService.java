package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){

        // 이미 존재하는 경우
        if (userRepository.findByAddress(user.getAddress()).isPresent()){
            return null;
        }

        // 신규 유저
        return userRepository.save(user);
    }
    public Optional<User> getByAddress(String address){
        return userRepository.findByAddress(address);
    }

}