package com.blog.api.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class UserDto {

    private Integer id;
    private String name;
    private String password;
    public String email;
    public String about;

}
