package com.example.ChoThueXe.dto.request;

import lombok.Getter;

import javax.persistence.Column;
import java.util.Date;

@Getter

public class NhanVienRequest {

    private String code;

    private String hoTen;

    private String diaChi;

    private String ngaySinh;

    private String email;

    private String sdt;

    private String note;
}
