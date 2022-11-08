package com.its.member.Controller;

import com.its.member.dto.MemberDTO;
import com.its.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
