package com.example.ChoThueXe.entity;

import com.example.ChoThueXe.base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Table(name = "nhan_vien")
@Entity
@Where(clause = "is_deleted = false")
@AttributeOverride(column = @Column(name = "nhanvien_id"), name = "id")

public class NhanVienEntity extends BaseEntity {

    @Column(name = "ho_ten")
    private String hoTen;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "ngay_sinh")
    private Date ngaySinh;

    @Column(name = "email")
    private String email;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "note")
    private String note;

    public NhanVienEntity(String hoTen, String diaChi, String ngaySinh, String email, String sdt, String note) throws ParseException {
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.ngaySinh = dateFormat.parse(ngaySinh);
        this.email = email;
        this.sdt = sdt;
        this.note = note;
    }
}
