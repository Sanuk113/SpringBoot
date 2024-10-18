package com.pos.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@NoArgsConstructor
public class LoginRequestDTO {

    @NonNull
    private String username;

    @NonNull
    @ToString.Exclude  // Exclude password from logs and debug prints
    private String password;

    // Constructor with parameters
    public LoginRequestDTO(@NonNull String username, @NonNull String password) {
        this.username = username;
        this.password = password;
    }
}
