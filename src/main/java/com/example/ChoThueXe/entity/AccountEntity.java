package com.example.ChoThueXe.entity;

import com.example.ChoThueXe.base.BaseEntity;
import com.example.ChoThueXe.dto.request.AccountRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Setter
@Getter
@NoArgsConstructor
@Table(name = "account")
@Entity
@Where(clause = "is_deleted = false")
@AttributeOverride(column = @Column(name = "account_id"), name = "id")

public class AccountEntity extends BaseEntity {

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @OneToOne
    @JoinColumn(name = "nhanvien_id")
    private NhanVienEntity nhanVien;

    public AccountEntity(String username, String password, String role, NhanVienEntity nhanVien) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.nhanVien = nhanVien;
    }

    public void update(AccountRequest request) throws ParseException {
        this.password=request.getPassword();
        this.nhanVien.setHoTen(request.getNhanVienRequest().getHoTen());
        this.nhanVien.setDiaChi(request.getNhanVienRequest().getDiaChi());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.nhanVien.setNgaySinh(dateFormat.parse(request.getNhanVienRequest().getNgaySinh()));
        this.nhanVien.setEmail(request.getNhanVienRequest().getEmail());
        this.nhanVien.setSdt(request.getNhanVienRequest().getSdt());
        this.nhanVien.setNote(request.getNhanVienRequest().getNote());
    }
}
