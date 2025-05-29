package Jugo.backend.dto;

import Jugo.backend.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AuthRequest extends User {
    private String name;
    private String password;
}
