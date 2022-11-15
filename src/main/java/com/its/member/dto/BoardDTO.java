package com.its.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class BoardDTO {
    private Long id;
    private String boardTitle;
    private String boardWriter;
    private String boardContents;
    private int boardHits;
    private Timestamp boardCreatedDate;
    private Long memberId;
    private String boardFileName;
    // 파일을 담기위한 필드
    private MultipartFile boardFile;
    // 원본파일 이름용 필드
    private String originalFileName;
    // 서버관리 이름용 필드
    private String storedFileName;
    // 파일첨부 여부
    private int fileAttached;
}
