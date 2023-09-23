package com.example.shipping.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersRequest {
    private Long id;
    private String userName;
    private String passWord;
    private String firstName;
    private String lastName;
    private String address;
    private Long telephone;
    private String createdAt;
    private String modifiedAt;

}
