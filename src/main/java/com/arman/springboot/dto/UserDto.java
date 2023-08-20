package com.arman.springboot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "UserDto Model Information"
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;

    @Schema(
            description = "User First Name"
    )
    @NotEmpty(message = "First name should not be empty or null")
    private String firstName;

    @Schema(
            description = "User Last Name"
    )
    @NotEmpty(message = "Last name should not be empty or null")
    private String lastName;

    @Schema(
            description = "User Email Address"
    )
    @NotEmpty(message = "Email address should not be empty or null")
    @Email(message = "Email address should be valid")
    private String email;
}
