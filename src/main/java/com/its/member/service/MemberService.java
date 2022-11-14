package com.its.member.service;

import com.its.member.dto.MemberDTO;
import com.its.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public boolean loginMember(MemberDTO memberDTO) {
        MemberDTO memberDTO1 = memberRepository.loginMember(memberDTO);
        if (memberDTO1 != null) {
            return true;
        } else {
            return false;
        }
    }

    public String emailDuplicate(String memberEmail) {
       String checkResult = memberRepository.emailDuplicate(memberEmail);
       if (checkResult == null) {
           return "ok";
       } else {
           return "no";
       }
    }

    public List<MemberDTO> findAll() {
       return memberRepository.findAll();
    }

    public MemberDTO findById(Long id) {
        return memberRepository.findById(id);
    }

    public void delete(Long id) {
        memberRepository.delete(id);
    }

    public MemberDTO findByEmail(String memberEmail) {
        return memberRepository.findByEmail(memberEmail);
    }

    public boolean update(MemberDTO memberDTO) {
        int result = memberRepository.update(memberDTO);
        if (result > 0 ) {
            return true;
        } else {
            return false;
        }
    }
}
