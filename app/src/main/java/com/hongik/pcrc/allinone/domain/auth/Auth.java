package com.hongik.pcrc.allinone.domain.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class Auth {

    private String id;
    private String password;
    private String name;
    private String gender;
    private String phoneNumber;

}
