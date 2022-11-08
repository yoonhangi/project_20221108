package com.its.member.service;

import com.its.member.dto.MemberDTO;
import com.its.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;
    public boolean saveMember(MemberDTO memberDTO) {
       int result =  memberRepository.saveMember(memberDTO);
       if (result > 0) {
           return true;
       } else {
           return false;
       }
    }
}
