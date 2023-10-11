package com.trade.api.models.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author claudio.vilas
 * date 09/2023
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserResponse implements Serializable {
    private Long id;
    private String username;
    private String contactNumber;
    private String email;
    private String status;
    private String role;
    private LocalDate createAt;
    private LocalDate updatedAt;
}
