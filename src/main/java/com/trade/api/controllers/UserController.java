package com.trade.api.controllers;

import com.trade.api.models.request.UserRequest;
import com.trade.api.models.responses.UserResponse;
import com.trade.infrastructure.services.contracts.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author claudio.vilas
 * date 09/2023
 */

@RestController
@RequestMapping("/api/v1/trade/users")
@Slf4j
@RequiredArgsConstructor
@Tag(name = "GESTION - USUARIOS")
public class UserController {
    private final UserService userService;

    @PostMapping
    @Operation(summary = "servicio para alta de usuarios al sistema",
            description = "servicio para alta de usuarios al sistema")
    @Parameter(name = "request", description = "datos del usuario")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "created"),
            @ApiResponse(responseCode = "400", description = "bad request"),
            @ApiResponse(responseCode = "500", description = "internal server error")
    })
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest request){
        log.info("#### endpoint alta de clientes ####");
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.create(request));
    }
}
