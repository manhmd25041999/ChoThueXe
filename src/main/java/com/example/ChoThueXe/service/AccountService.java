package com.example.ChoThueXe.service;

import com.example.ChoThueXe.base.BaseService;
import com.example.ChoThueXe.base.UuidUtils;
import com.example.ChoThueXe.dto.request.AccountRequest;
import com.example.ChoThueXe.entity.AccountEntity;
import com.example.ChoThueXe.entity.NhanVienEntity;
import com.example.ChoThueXe.exception.BadRequestException;
import com.example.ChoThueXe.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

@Service
public class AccountService extends BaseService<AccountEntity, AccountRepository> {

    @Autowired
    private NhanVienService nhanVienService;

    public AccountEntity create(AccountRequest request) throws ParseException {
        boolean createNew = request.getCode() == null;
        if (createNew) {
            if (repository.countByUsername(request.getUsername()) != 0) {
                throw new BadRequestException("Username was used!");
            }
            NhanVienEntity nhanVienEntity = nhanVienService.create(request.getNhanVienRequest());
            return createAndSave(new AccountEntity(request.getUsername(), request.getPassword(), request.getRole(), nhanVienEntity));
        }else{
            UUID uuid = UuidUtils.getUuidFromStringOrElseNull(request.getCode());
            AccountEntity accountEntity = findByCode(uuid);
            accountEntity.update(request);
            nhanVienService.update(accountEntity.getNhanVien());
            return update(accountEntity);
        }
    }

    public AccountEntity login(String username, String password){
        return this.repository.findByUsernameAndPassword(username, password);
    }

    public boolean delete(String code){
        UUID uuid = UuidUtils.getUuidFromStringOrElseNull(code);
        boolean delete = nhanVienService.delete(findByCode(uuid).getNhanVien());
        if(delete){
            return this.delete(uuid);
        }
        throw new BadRequestException("remove fail!");
    }

    public List<AccountEntity> getAll(){
        return repository.findByIsDeletedFalse();
    }

}
