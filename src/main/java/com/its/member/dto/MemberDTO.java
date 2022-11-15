package com.its.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class MemberDTO {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
    private String memberMobile;
    // 파일을 담기위한 필드
    private MultipartFile memberFile;
    // 원본파일 이름용 필드
    private String originalFileName;
    // 서버관리 이름용 필드
    private String storedFileName;
    // 파일첨부 여부
    private int fileAttached;
}
