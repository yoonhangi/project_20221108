package com.its.member.service;

import com.its.member.dto.MemberDTO;
import com.its.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;
    public void saveMember(MemberDTO memberDTO) throws IOException {
        if (!memberDTO.getMemberFile().isEmpty()) {
            System.out.println("파일있음");
            MultipartFile memberFile = memberDTO.getMemberFile(); // 1.
            String originalFilename = memberFile.getOriginalFilename(); // 2.
            System.out.println("originalFilename = " + originalFilename);
            System.out.println(System.currentTimeMillis());
            String storedFileName = System.currentTimeMillis() + "-" + originalFilename; // 3.
            System.out.println("storedFileName = " + storedFileName);
            memberDTO.setOriginalFileName(originalFilename);
            memberDTO.setStoredFileName(storedFileName); // 4.
            String savePath = "D:\\spring_img\\" + storedFileName; // 5.
            memberFile.transferTo(new File(savePath)); // 6.
            memberDTO.setFileAttached(1);
            MemberDTO savedMember = memberRepository.saveMember(memberDTO); // 7.
            memberRepository.saveFileName(savedMember);
        } else {
            System.out.println("파일없음");
            memberDTO.setFileAttached(0);
            memberRepository.saveMember(memberDTO);
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
