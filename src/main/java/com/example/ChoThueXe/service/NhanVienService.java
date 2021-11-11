package com.example.ChoThueXe.service;

import com.example.ChoThueXe.base.BaseService;
import com.example.ChoThueXe.dto.request.NhanVienRequest;
import com.example.ChoThueXe.entity.NhanVienEntity;
import com.example.ChoThueXe.repository.NhanVienRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class NhanVienService extends BaseService<NhanVienEntity, NhanVienRepository> {

    public NhanVienEntity create(NhanVienRequest request) throws ParseException {
        return createAndSave(new NhanVienEntity(request.getHoTen(), request.getDiaChi(), request.getNgaySinh(), request.getEmail(), request.getSdt(), request.getNote()));
    }
}
