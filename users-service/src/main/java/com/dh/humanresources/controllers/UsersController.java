package com.dh.humanresources.controllers;

import com.dh.humanresources.model.User;
import com.dh.humanresources.model.dto.UserRequest;
import com.dh.humanresources.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UsersController {
    private final IUserService userService;

    @GetMapping()
    public String hello() {
        return "hello";
    }

    @PostMapping("/altaEmpleado")
    @PreAuthorize("hasRole('ROLE_EMPLEADO_RH')")
    public String altaEmpleado() {
        return "Se dió de alta un empleado";
    }

    @PostMapping("/create")
    public Map<String, String> createUser(@RequestBody Map<String, String> user) {
        return user;
    }

    @PostMapping("/bajaEmpleado")
    @PreAuthorize("hasRole('ROLE_ADMIN_RH')")
    public String bajaEmpleado() {
        return "Se dió de baja un empleado";
    }

    @PostMapping("/editarInformacion")
    @PreAuthorize("hasRole('ROLE_EMPLEADO')")
    public String editarInformacion() {
        return "Se modificó la información personal del empleado";
    }

    @GetMapping("/all")
    public Map<String, String> findAll() {
        return new HashMap();
    }

    @GetMapping("/find/{id}")
    public Map<String, String> findOne(@PathVariable String id) {
        return new HashMap();
    }

    @DeleteMapping("/delete")
    public Map<String, String> delete() {
        return new HashMap();
    }

    //TODO  estos dos endpoints funcionaran cuando este configurada la seguridad en el proyecto
    /*@GetMapping("/me")
  public User getUserExtra(Principal principal) {
    return userService.validateAndGetUserExtra(principal.getName());
  }*/

    @GetMapping("/me")
    public User getUserExtra(@RequestParam String principal) {
        return userService.validateAndGetUserExtra(principal);
    }

    @PostMapping("/me")
    public User saveUserExtra(@Valid @RequestBody UserRequest updateUserRequest, @RequestParam(value = "principal") String principal) {
        Optional<User> userOptional = userService.getUserExtra(principal);
        User userExtra = userOptional.orElseGet(() -> new User(principal));
        userExtra.setAvatar(updateUserRequest.getAvatar());
        return userService.saveUserExtra(userExtra);
    }
}
