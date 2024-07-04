package com.example.firsttask.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberDto {
    private String userId;
    private String password;
    private String email;

}
