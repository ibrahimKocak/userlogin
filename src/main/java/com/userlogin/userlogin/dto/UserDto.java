package com.userlogin.userlogin.dto;

import com.userlogin.userlogin.constant.AccountTypeEnum;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private String id;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private AccountTypeEnum accountType;
    private String creationTime;
    private String lastUpdateTime;
    private String birthday;
}
