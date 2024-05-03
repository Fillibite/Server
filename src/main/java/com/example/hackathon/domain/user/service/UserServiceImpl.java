package com.example.hackathon.domain.user.service;

import com.example.hackathon.domain.user.dto.UserRequestDTO;
import com.example.hackathon.domain.user.dto.UserResponseDTO;
import com.example.hackathon.domain.user.entity.User;
import com.example.hackathon.domain.user.repository.UserRepository;
import com.example.hackathon.global.common.CommonMethod;
import com.example.hackathon.global.common.exception.CustomException;
import com.example.hackathon.global.common.reponse.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    final private UserRepository userRepository;
    final private CommonMethod commonMethod;
    final private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    @Transactional
    public UserResponseDTO.UserJoinDTO join(UserRequestDTO.UserJoinDTO userJoinDTO) {
        try {
            log.info("[UserServiceImpl] join");
            if (userRepository.existsByUserEmail(userJoinDTO.getUserEmail())) {
                throw new CustomException(ErrorCode.USER_EXIST);
            }

            userJoinDTO.setUserPassword(bCryptPasswordEncoder.encode(userJoinDTO.getUserPassword()));

            User user = userJoinDTO.toEntity();
            userRepository.save(user);
            return new UserResponseDTO.UserJoinDTO(user);
        } catch (CustomException ce){
            log.info("[CustomException] UserServiceImpl join");
            throw ce;
        } catch (Exception e){
            log.info("[Exception500] UserServiceImpl join");
            throw new CustomException(ErrorCode.SERVER_ERROR, "[Exception500] UserServiceImpl join : " + e.getMessage());
        }
    }
}
