package com.blog.api.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter

public class UserDto {

    private Integer id;
    @NotEmpty
    @Size(min = 4, message = "Username should be minimum of 4 chars")
    private String name;
    @NotEmpty
    @Size(min = 4, message = "Password should be minimum of 4 chars")
    private String password;
    @Email(message = "Email not valid")
    public String email;
    @NotEmpty
    public String about;

}
