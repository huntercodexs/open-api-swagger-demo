package com.huntercodexs.openapiswaggerdemo.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Schema(description = "This object refers to UserResponse", name = "UserResponse")
public class UserResponseDto {

    @Schema(
            description = "Username of the user to be create (email or cpf).",
            example = "88888888888",
            required = true)
    String username;

    @Schema(
            description = "The password to user.",
            example = "123456789",
            required = true)
    String password;

    @Schema(
            description = "The name of the user to be create",
            example = "Mario Silva Santos",
            required = true)
    String name;

    @Schema(
            description = "The mail address of the user to be created.",
            example = "mariosantos@email.com",
            required = true)
    String mail;

    @Schema(
            description = "The date of user was created.",
            example = "11/03/2021 14:08:49",
            required = false)
    String createdAt;

    @Schema(
            description = "The date of user was updated.",
            example = "11/08/2021 11:08:49",
            required = false)
    String updatedAt;

    @Schema(
            description = "This field show if user is active or no.",
            example = "no", 
            required = false)
    String active;

}
