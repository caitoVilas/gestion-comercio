package com.trade.infrastructure.services.impl;

import com.trade.api.models.request.UserRequest;
import com.trade.api.models.responses.UserResponse;
import com.trade.domain.dao.UserDao;
import com.trade.domain.entities.UserEntity;
import com.trade.infrastructure.services.contracts.UserService;
import com.trade.util.constants.UserConstants;
import com.trade.util.map.UserMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author claudio.vilas
 * date 09/2023
 */

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;


    @Override
    public UserResponse create(UserRequest request) {
        log.info("--> inicio servicio alta de usuario");
        log.info("---> validando entradas...");
        this.validateUser(request);
        var user = UserEntity.builder()
                .username(request.getUsername())
                .contactNumber(request.getContactNumber())
                .password(request.getPassword())
                .email(request.getEmail())
                .status("A")
                .role("ROLE_USER")
                .build();
        log.info("---> guardando usuario...");
        var userNew = userDao.save(user);
        return UserMap.mapToDto(userNew);
    }

    private void validateUser(UserRequest request){
        if (request.getUsername().isBlank()){
            log.error("ERROR: ".concat(UserConstants.U_NO_NAME));
            throw new RuntimeException(UserConstants.U_NO_NAME);
        }
        if (request.getPassword().isBlank()){
            log.error("ERROR: ".concat(UserConstants.U_NO_PASS));
            throw new RuntimeException(UserConstants.U_NO_PASS);
        }
        if (request.getContactNumber().isBlank()){
            log.error("ERROR: ".concat(UserConstants.U_NO_CONTACT));
            throw new RuntimeException(UserConstants.U_NO_CONTACT);
        }
        if (request.getEmail().isBlank()){
            log.error("ERROR: ".concat(UserConstants.U_EMAIL_EMPTY));
            throw new RuntimeException(UserConstants.U_EMAIL_EMPTY);
        }
        if (userDao.findByEmail(request.getEmail())){
            log.error("ERROR: ".concat(UserConstants.U_EMAIL_EXISTS.concat(request.getEmail())));
            throw new RuntimeException(UserConstants.U_EMAIL_EXISTS.concat(request.getEmail()));
        }
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(request.getEmail());
        if (matcher.find()) {
            log.info("---> mail valido");
        }else{
            log.error("ERROR: ".concat(UserConstants.U_EMAIL_INVALID));
            throw new RuntimeException(UserConstants.U_EMAIL_INVALID);
        }
    }
}
