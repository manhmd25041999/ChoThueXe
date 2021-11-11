package com.example.ChoThueXe.dto.request;

import lombok.Getter;

import javax.persistence.Column;

@Getter

public class AccountRequest {

    private String code;

    private String username;

    private String password;

    private String role;

    private NhanVienRequest nhanVienRequest;
}
