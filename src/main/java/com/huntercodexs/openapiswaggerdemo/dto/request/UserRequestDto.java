package com.huntercodexs.openapiswaggerdemo.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Schema(description = "This object refers to UserRequest", name = "UserRequest")
public class UserRequestDto {

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

}
