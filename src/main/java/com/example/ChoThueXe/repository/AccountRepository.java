package com.example.ChoThueXe.repository;

import com.example.ChoThueXe.base.BaseRepository;
import com.example.ChoThueXe.entity.AccountEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends BaseRepository<AccountEntity> {

    long countByUsername(String username);

    AccountEntity findByUsernameAndPassword(String username, String password);
}
