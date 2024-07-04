package com.example.firsttask.controller;

import com.example.firsttask.Dto.MemberDto;
import com.example.firsttask.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    //회원가입
    @PostMapping("/register")
    public Map<String, String> getUserId(@RequestBody MemberDto memberDto) {
        memberService.registerMember(memberDto);
        Map<String, String> userId = new HashMap<>();
        userId.put("userId", memberDto.getUserId());
        return userId;
    }

    //유저정보조회
    @GetMapping
    public Map<String, String> getUserInformation(@RequestParam String userId) {
        Map<String, String> userInformation = new HashMap<>();
        userInformation.put("userId", userId);
        userInformation.put("email", memberService.getUserEmail(userId));
        return userInformation;
    }


    //유저정보수정
    @PatchMapping
    public String changeEmail(@RequestParam String userId, @RequestBody MemberDto memberDto) {
        memberService.changeEmail(userId, memberDto);
        return userId;
    }

    //유저삭제
    @DeleteMapping("/{userId}")
    public String deleteMember(@PathVariable String userId) {
        memberService.deleteMember(userId);
        return userId;
    }

    //비밀번호변경
    @PostMapping("/password")
    public String changePassword(@RequestParam String userId, @RequestBody MemberDto memberDto) {
        memberService.changePassword(userId, memberDto);
        return userId;
    }

}
