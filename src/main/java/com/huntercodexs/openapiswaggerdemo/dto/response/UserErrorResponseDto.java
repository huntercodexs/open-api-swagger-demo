package com.huntercodexs.openapiswaggerdemo.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Schema(description = "This object refers to UserErrorResponse", name = "UserErrorResponse")
public class UserErrorResponseDto {

    @Schema(
            description = "Integer value that indicates the executed module code.",
            example = "404", required = true
    )
    int codeError;

    @Schema(
            description = "Text message describing the error found.",
            example = "Resource or method not found", required = true
    )
    String message;

}
