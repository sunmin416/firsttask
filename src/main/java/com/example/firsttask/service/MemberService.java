package com.example.firsttask.service;


import com.example.firsttask.Dto.MemberDto;
import com.example.firsttask.domain.Member;
import com.example.firsttask.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService  {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원가입
    public void registerMember(MemberDto memberDto) {
        String userId = memberDto.getUserId();
        String password = memberDto.getPassword();
        String email = memberDto.getEmail();

        Member newMember = new Member();
        newMember.setUserId(userId);
        newMember.setPassword(password);
        newMember.setEmail(email);

        memberRepository.save(newMember);
    }

    //userId->userId, email
    public String getUserEmail(String userId) {
        Member existingMember = memberRepository.findByUserId(userId);
        return existingMember.getEmail();
    }

    //userId->email 수정
    public String changeEmail(String userId, MemberDto memberDto) {
        Member email = memberRepository.findByUserId(userId);
        email.setEmail(memberDto.getEmail());
        memberRepository.save(email);
        return userId;
    }

    //userId->유저삭제
    public String deleteMember(String userId) {
        Member member = memberRepository.findByUserId(userId);
        memberRepository.delete(member);
        return userId;
    }

    //userId->password 변경
    public String changePassword(String userId, MemberDto memberDto) {
        Member password = memberRepository.findByUserId(userId);
        password.setPassword(memberDto.getPassword());
        memberRepository.save(password);
        return userId;
    }

}