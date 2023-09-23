package com.example.shipping.controller;

import com.example.shipping.dto.UsersResponse;
import com.example.shipping.dto.request.UsersRequest;
import com.example.shipping.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UsersController {
    final UsersService usersService;

    @GetMapping(value = "/usersList")
    public List<UsersResponse> getUsersInfo(){
        return usersService.getAll();
    }
    @GetMapping(value = "/getUsersById/{id}")
    public UsersResponse getUserById(@PathVariable(value = "id")Long id){
        return usersService.getUserById(id);
    }
    @PostMapping(value = "/saveUsers")
    public void saveUsers(@RequestBody UsersRequest usersRequest){
        usersService.saveUsers(usersRequest);
    }
    @PostMapping(value = "/updateUsers")
    public void updateUsers(@RequestBody UsersRequest usersRequest)
    {
        usersService.updateUsers(usersRequest);
    }
    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable(value = "id")Long id){
        usersService.deleteById(id);
    }
}
