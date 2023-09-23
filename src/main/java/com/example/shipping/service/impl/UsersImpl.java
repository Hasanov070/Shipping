package com.example.shipping.service.impl;

import com.example.shipping.dto.UsersResponse;
import com.example.shipping.dto.request.UsersRequest;
import com.example.shipping.model.Users;
import com.example.shipping.repository.UsersRepository;
import com.example.shipping.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersImpl implements UsersService {
    final UsersRepository usersRepository;

    @Override
    public UsersResponse getUserById(Long id) {
        Users users = usersRepository.getUsersById(id);
        return UsersResponse.builder()
                .userName(users.getUserName())
                .firstName(users.getFirstName())
                .lastName(users.getLastName())
                .createdAt(users.getCreatedAt())
                .modifiedAt(users.getModifiedAt())
                .build();
    }

    @Override
    public void saveUsers(UsersRequest usersRequest) {
        Users users = Users.builder()
                .userName(usersRequest.getUserName())
                .firstName(usersRequest.getFirstName())
                .lastName(usersRequest.getLastName())
                .createdAt(usersRequest.getCreatedAt())
                .build();
        usersRepository.save(users);


    }

    @Override
    public void updateUsers(UsersRequest usersRequest) {
        Users users = Users.builder()
                .id(usersRequest.getId())
                .userName(usersRequest.getUserName())
                .passWord(usersRequest.getPassWord())
                .firstName(usersRequest.getFirstName())
                .lastName(usersRequest.getLastName())
                .address(usersRequest.getAddress())
                .telephone(usersRequest.getTelephone())
                .modifiedAt(usersRequest.getModifiedAt())
                .build();

        usersRepository.save(users);


    }

    @Override
    public void deleteById(Long id) {
        if (id == null)
        {
            throw new RuntimeException("There is no such information");

        }
        else {
            usersRepository.deleteById(id);
        }

    }

    @Override
    public List<UsersResponse> getAll() {
        List<Users> users = usersRepository.findAll();
        List<UsersResponse> usersResponses = new ArrayList<>();

        for (Users users1 : users)
        {
            UsersResponse usersResponse = UsersResponse.builder()
                    .userName(users1.getUserName())
                    .firstName(users1.getFirstName())
                    .lastName(users1.getLastName())
                    .createdAt(users1.getCreatedAt())
                    .modifiedAt(users1.getModifiedAt())
                    .build();
            usersResponses.add(usersResponse);
        }
        return usersResponses;
    }
}
