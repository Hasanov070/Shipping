package com.example.shipping.service;

import com.example.shipping.dto.UsersResponse;
import com.example.shipping.dto.request.UsersRequest;

import java.util.List;

public interface UsersService {
    UsersResponse getUserById(Long id);
    void saveUsers(UsersRequest usersRequest);
    void updateUsers(UsersRequest usersRequest);
    void deleteById(Long id);
    List<UsersResponse> getAll();
}
