package com.its.member.repository;

import com.its.member.dto.MemberDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {
    @Autowired
    private SqlSessionTemplate sql;
    public int saveMember(MemberDTO memberDTO) {
        return sql.insert("Member.saveMember", memberDTO);
    }

    public MemberDTO loginMember(MemberDTO memberDTO) {
        return sql.selectOne("Member.loginMember", memberDTO);
    }

    public String emailDuplicate(String memberEmail) {
        return sql.selectOne("Member.duplicate", memberEmail);
    }

    public List<MemberDTO> findAll() {
        return sql.selectList("Member.findAll");
    }

    public MemberDTO findById(Long id) {
        return sql.selectOne("Member.findById",id);
    }
}
