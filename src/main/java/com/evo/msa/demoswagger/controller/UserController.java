package com.evo.msa.demoswagger.controller;

import com.evo.msa.demoswagger.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@Api("Api de ejemplo para probar el starter de swagger")
public class UserController {

    private static final User FULANO = User.builder().username("FULANO").email("fulano@aaa.com").phone("111222333").build();

    private static final List<User> MENGANO_LIST = Arrays.asList(
            User.builder().username("MENGANO1").email("mengano1@aaa.com").phone("111222333").build(),
            User.builder().username("MENGANO2").email("mengano2@aaa.com").phone("111222333").build(),
            User.builder().username("MENGANO3").email("mengano3@aaa.com").phone("111222333").build()
    );

    @GetMapping("/users/{name}")
    @ApiOperation(value = "Obtiene un usuario por su nombre", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Status Ok")
    })
    public ResponseEntity<User> getUsers(@PathVariable String name) {
        return ResponseEntity.ok(FULANO);
    }

    @GetMapping("/users")
    @ApiOperation(value = "Obtiene el listado de usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Status Ok")
    })
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(MENGANO_LIST);
    }

    @PostMapping("/users")
    @ApiOperation(value = "Crea un nuevo usuario", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Status Ok")
    })
    public ResponseEntity<String> getUserByName(@RequestBody User user) {
        return ResponseEntity.ok("Usuario insertado correctamente");
    }

}