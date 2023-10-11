package com.trade.infrastructure.services.contracts;

import com.trade.api.models.request.UserRequest;
import com.trade.api.models.responses.UserResponse;

/**
 * @author claudio.vilas
 * date 09/2023
 */

public interface UserService {
    UserResponse create(UserRequest request);

}
