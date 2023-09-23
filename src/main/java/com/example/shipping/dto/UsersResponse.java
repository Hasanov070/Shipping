package com.example.shipping.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersResponse {
    private String userName;
    private String firstName;
    private String lastName;
    private String createdAt;
    private String modifiedAt;





}
