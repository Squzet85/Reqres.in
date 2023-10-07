package org.example.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserResponse {
    public Integer id;
    public String email;
    public String first_name;
    public String last_name;
    public String avatar;
}
