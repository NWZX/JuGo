package Jugo.backend.service;

import Jugo.backend.dto.UserDTO;
import Jugo.backend.entity.User;
import Jugo.backend.mapper.UserMapper;
import Jugo.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDTO create(UserDTO dto) {
        User user = userMapper.toEntity(dto);
        User savedUser = userRepository.save(user);

        return userMapper.toDto(savedUser);
    }

    public List<UserDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException("User not found");

        return user;
    }
}
