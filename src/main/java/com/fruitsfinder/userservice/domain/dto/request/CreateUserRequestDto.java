package com.fruitsfinder.userservice.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequestDto {
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String email;
}
