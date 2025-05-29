package Jugo.backend.controller;

import Jugo.backend.dto.UserDTO;
import Jugo.backend.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO dto) {
        return userService.create(dto);
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.findAll();
    }
}
