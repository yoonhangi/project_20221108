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
    public MemberDTO saveMember(MemberDTO memberDTO) {
        sql.insert("Member.saveMember", memberDTO);
        return memberDTO;
    }

    public void saveFileName(MemberDTO savedMember) {
        sql.insert("Member.saveFile", savedMember);
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
        MemberDTO memberDTO = sql.selectOne("Member.findById", id);
        if (memberDTO.getFileAttached() == 1) {
            return sql.selectOne("Member.findByIdFile", id);
        } else {
            return memberDTO;
        }
    }

    public void delete(Long id) {
        sql.delete("Member.delete", id);
    }

    public MemberDTO findByEmail(String memberEmail) {
        return sql.selectOne("Member.findByEmail", memberEmail);
    }

    public int update(MemberDTO memberDTO) {
        return sql.update("Member.update", memberDTO);
    }

}
