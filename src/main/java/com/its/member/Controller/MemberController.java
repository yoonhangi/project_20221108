package com.its.member.Controller;

import com.its.member.dto.MemberDTO;
import com.its.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;
    @GetMapping("/save")
    public String save() {
        return "memberPages/memberSave";
    }

    @PostMapping("/save")
    public String saveMember(@ModelAttribute MemberDTO memberDTO, Model model) {
        boolean result = memberService.saveMember(memberDTO);
        model.addAttribute("result", result);
        if (result) {
            return "memberPages/memberLogin";
        } else {
            return "index";
        }
    }
    @GetMapping("/login")
    public String login() {
        return "memberPages/memberLogin";
    }

    @PostMapping("/login")
    public String loginMember(@ModelAttribute MemberDTO memberDTO, HttpSession session, Model model) {
       boolean loginMember = memberService.loginMember(memberDTO);
       if (loginMember) {
            session.setAttribute("loginEmail", memberDTO.getMemberEmail());
            model.addAttribute("modelEmail", memberDTO.getMemberEmail());
            return "memberPages/memberMain";
        } else {
            return "memberPages/memberLogin";
       }
    }

    @PostMapping("/duplicate-check")
    public @ResponseBody String emailDuplicate(@RequestParam("inputEmail") String memberEmail) {
        String checkResult = memberService.emailDuplicate(memberEmail);
        return checkResult;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "index";
    }
}
