package com.trade.util.map;

import com.trade.api.models.responses.UserResponse;
import com.trade.domain.entities.UserEntity;

/**
 * @author claudio.vilas
 * date 09/2023
 */

public class UserMap {
    public static UserResponse mapToDto(UserEntity user){
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .contactNumber(user.getContactNumber())
                .email(user.getEmail())
                .status(user.getStatus())
                .role(user.getRole())
                .createAt(user.getCreateAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }
}
