package com.shop.models.binding;

import com.shop.models.validators.FieldMatch;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@FieldMatch(first = "password", second = "rePassword")
public class UserRegisterBindingModel {

    @NotEmpty
    @Size(min = 5, max = 20, message = "Username must be between 5 and 15 characters")
    private String username;

    @NotEmpty
    @Size(min = 5, max = 20, message = "Username must be between 5 and 10 characters")
    private String password;

    @NotEmpty
    private String rePassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

}
