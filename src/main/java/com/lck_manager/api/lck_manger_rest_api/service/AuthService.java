package com.lck_manager.api.lck_manger_rest_api.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Value("${api_key.value}")
    private String key;

    public boolean checkAuth(String inputKey) {
        boolean check = false;

        if(inputKey.equals(key)) {
            check = true;
        }

        return check;
    }
}
