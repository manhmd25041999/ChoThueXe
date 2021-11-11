package com.example.ChoThueXe.dto.response;

import com.example.ChoThueXe.base.BaseDto;
import com.example.ChoThueXe.base.BaseEntity;
import com.example.ChoThueXe.entity.NhanVienEntity;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;

@Setter
@Getter

public class NhanVienDto extends BaseDto {

    private String hoTen;

    private String diaChi;

    private String ngaySinh;

    private String email;

    private String sdt;

    private String note;

    public NhanVienDto(NhanVienEntity entity) {
        super(entity);
        this.hoTen = entity.getHoTen();
        this.diaChi = entity.getDiaChi();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.ngaySinh = dateFormat.format(entity.getNgaySinh());
        this.email = entity.getEmail();
        this.sdt = entity.getSdt();
        this.note = entity.getNote();
    }
}
