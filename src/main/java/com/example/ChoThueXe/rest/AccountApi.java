package com.example.ChoThueXe.rest;

import com.example.ChoThueXe.base.BaseResource;
import com.example.ChoThueXe.dto.request.AccountRequest;
import com.example.ChoThueXe.dto.response.AccountDto;
import com.example.ChoThueXe.dto.response.CustomResponse;
import com.example.ChoThueXe.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/account")
public class AccountApi extends BaseResource<AccountService> {

    @PostMapping("/create")
    public CustomResponse<AccountDto> create(@RequestBody AccountRequest request) throws ParseException {
        return CustomResponse.ok(new AccountDto(this.service.create(request)));
    }


}
