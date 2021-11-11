package com.example.ChoThueXe.dto.response;

import com.example.ChoThueXe.base.BaseDto;
import com.example.ChoThueXe.entity.AccountEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AccountDto extends BaseDto {

    private String username;

    private String role;

    private NhanVienDto nhanVienDto;

    public AccountDto(AccountEntity entity) {
        super(entity);
        this.username = entity.getUsername();
        this.role = entity.getRole();
        this.nhanVienDto = new NhanVienDto(entity.getNhanVien());
    }
}
