package com.huntercodexs.openapiswaggerdemo.restcontroller;

import com.huntercodexs.openapiswaggerdemo.dto.request.UserRequestDto;
import com.huntercodexs.openapiswaggerdemo.dto.response.UserErrorResponseDto;
import com.huntercodexs.openapiswaggerdemo.dto.response.UserResponseDto;
import com.huntercodexs.openapiswaggerdemo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
@RestController
@RequestMapping("${api.prefix}")
@Tag(name = "Open Api Swagger Demo with Controller Advice")
@CrossOrigin(origins = "*")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    /**
     * Read User
     */
    @Operation(
            summary = "Get one user by id",
            description = "Description about this function"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Read one user successfully", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponseDto.class))
            }),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {
                    @Content(mediaType = "text")
            }),
            @ApiResponse(responseCode = "404", description = "User not found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserErrorResponseDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserErrorResponseDto.class))
            })
    })
    @GetMapping(path = "/users/{userid}")
    @ResponseBody
    public ResponseEntity<UserResponseDto> readOne(@PathVariable("userid") String userid) {
        return userService.readOne(userid);
    }

    /**
     * Read All Users
     */
    @Operation(
            summary = "Get all users",
            description = "Description about this function"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Read all users successfully", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponseDto.class))
            }),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {
                    @Content(mediaType = "text")
            }),
            @ApiResponse(responseCode = "404", description = "Users not found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserErrorResponseDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserErrorResponseDto.class))
            })
    })
    @GetMapping(path = "/api/users")
    @ResponseBody
    public ResponseEntity<UserResponseDto> readAll() {
        return userService.readAll();
    }

    /**
     * Create User
     */
    @Operation(
            summary = "Add new user by Rest Template",
            description = "Description about this function"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User created successfully", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponseDto.class))
            }),
            @ApiResponse(responseCode = "201", description = "User created successfully", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponseDto.class))
            }),
            @ApiResponse(responseCode = "302", description = "User name already exists", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserErrorResponseDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Missing body request", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserErrorResponseDto.class))
            }),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {
                    @Content(mediaType = "text")
            }),
            @ApiResponse(responseCode = "409", description = "User name already exists", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserErrorResponseDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Server error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserErrorResponseDto.class))
            })
    })
    @PostMapping(path = "/users")
    @ResponseBody
    public ResponseEntity<UserResponseDto> create(@RequestBody UserRequestDto user) {
        return userService.create(user);
    }

    /**
     * Delete User
     */
    @Operation(
            summary = "Delete an user by id",
            description = "Description about this function"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User deleted successfully", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponseDto.class))
            }),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {
                    @Content(mediaType = "text")
            }),
            @ApiResponse(responseCode = "404", description = "User not found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserErrorResponseDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserErrorResponseDto.class))
            })
    })
    @DeleteMapping(path = "/api/users/{userid}")
    @ResponseBody
    public ResponseEntity<UserResponseDto> delete(@PathVariable("userid") String userid) {
        return userService.delete(userid);
    }

    /**
     * Update User
     */
    @Operation(
            summary = "Update an user by id",
            description = "Description about this function"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated successfully", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponseDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Missing body request", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserErrorResponseDto.class))
            }),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {
                    @Content(mediaType = "text")
            }),
            @ApiResponse(responseCode = "404", description = "User not found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserErrorResponseDto.class))
            }),
            @ApiResponse(responseCode = "406", description = "Update is not correct, because it should be total data update", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserErrorResponseDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Server error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserErrorResponseDto.class))
            })
    })
    @PutMapping(path = "/api/users/{userid}")
    @ResponseBody
    public ResponseEntity<UserResponseDto> update(@PathVariable("userid") String userid, @RequestBody UserRequestDto user) {
        return userService.update(userid, user);
    }

    /**
     * Patch User
     */
    @Operation(
            summary = "Fix/Patch an user by id",
            description = "Description about this function"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User patched successfully", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponseDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Missing body request", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserErrorResponseDto.class))
            }),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {
                    @Content(mediaType = "text")
            }),
            @ApiResponse(responseCode = "404", description = "User not found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserErrorResponseDto.class))
            }),
            @ApiResponse(responseCode = "406", description = "Patch is not correct, because it should be partial update", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserErrorResponseDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserErrorResponseDto.class))
            })
    })
    @PatchMapping(path = "/api/users/{userid}")
    @ResponseBody
    public ResponseEntity<UserResponseDto> patch(@PathVariable("userid") String userid, @RequestBody UserResponseDto user) {
        return userService.patch(userid, user);
    }

    /**
     * Exceptions
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<?> handlerRootWebClientResponseException(HttpRequestMethodNotSupportedException ex) {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handlerRootWebClientRequestException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
    }

}
