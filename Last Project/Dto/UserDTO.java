package com.pos.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;

    @NonNull
    private String username;

    @NonNull
    @ToString.Exclude  // Prevent password from being printed in logs or console
    private String password;

    @NonNull
    private String role;  // "Admin" or "User"

    // Constructor without the 'id' field (for new users)
    public UserDTO(@NonNull String username, @NonNull String password, @NonNull String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
               "id=" + id +
               ", username='" + username + '\'' +
               ", role='" + role + '\'' +
               '}';
    }
}
