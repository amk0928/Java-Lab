package com.melong.map_struct.service;

import com.melong.map_struct.model.dto.User;
import com.melong.map_struct.model.entity.UserEntity;
import com.melong.map_struct.model.mapper.UserMapper;
import com.melong.map_struct.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional(readOnly = true)
    public UserEntity getUserEntity(User user) throws Exception {
        Optional<UserEntity> userEntityOptional = userRepository.findById(user.getSeq());
        if(userEntityOptional.isEmpty()) throw new Exception();
        return userEntityOptional.get();
    }

    @Transactional
    public void createUser(User user) {
        userRepository.save(userMapper.toEntity(user));
    }
}
