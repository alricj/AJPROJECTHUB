package com.bcbs.proofconcept.dao;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UserInfoDao {
    private Integer id;
    private String email;
    private String firstname;
    private String lastname;
    private String avatar;
    private String password;
    private String userName;
    private String roles;

}
