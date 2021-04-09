package com.example.backend.services;
import java.util.ArrayList;
import java.util.UUID;

import com.example.backend.repositories.UserRepository;
import com.example.backend.entities.UserEntity;
import com.example.backend.shared.dto.UserDto;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto createUser(UserDto user) {
        //TODO Este métdo va a crear un nuevo usuario

        if(userRepository.findByEmail(user.getEmail()) != null) 
            throw new RuntimeException("El usuario ya existe");

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        userEntity.setEncrypPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        UUID userId =  UUID.randomUUID();
        userEntity.setUserId(userId.toString());

        UserEntity storeUserDetails = userRepository.save(userEntity);
        UserDto userToReturn = new UserDto();
        BeanUtils.copyProperties(storeUserDetails, userToReturn);

        return userToReturn;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        /**
         * Éste método nos permite hacer el logeo del usaurio
         */
        UserEntity userEntity = userRepository.findByEmail(email);
        if(userEntity == null){
            throw new UsernameNotFoundException(email);
        }
        return new User(userEntity.getEmail(), userEntity.getEncrypPassword(), new ArrayList<>());
    }

    @Override
    public UserDto getUser(String email){
        UserEntity userEntity = userRepository.findByEmail(email);
        if(userEntity == null){
            throw new UsernameNotFoundException(email);
        }
        UserDto userToReturn = new UserDto();

        BeanUtils.copyProperties(userEntity, userToReturn);

        return userToReturn;
    }
}
