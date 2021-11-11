package com.example.ChoThueXe.base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseRequestDto {
    public abstract void selfValidate();
}
