package com.lavanderia.application.service;

import com.lavanderia.application.dto.LoginRequest;
import com.lavanderia.application.dto.LoginResponse;

public interface IAuthService {
    LoginResponse authenticate(LoginRequest loginRequest);
}
