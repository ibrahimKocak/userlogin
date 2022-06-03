package com.userlogin.userlogin.entity;

import com.userlogin.userlogin.constant.AccountTypeEnum;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "user")
public class User {

    private String id;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private AccountTypeEnum accountType;
    @NotNull
    private Date creationTime;
    private Date lastUpdateTime;
    private Date birthday;
}
