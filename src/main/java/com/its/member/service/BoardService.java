package com.its.member.service;

import com.its.member.commons.PagingConst;
import com.its.member.dto.BoardDTO;
import com.its.member.dto.PageDTO;
import com.its.member.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public boolean save(BoardDTO boardDTO) {
        int result = boardRepository.save(boardDTO);
        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }

    public List<BoardDTO> findAll() {
       List<BoardDTO> boardDTOList = boardRepository.findAll();
       return boardDTOList;
    }

    public BoardDTO findById(Long id) {
        return boardRepository.findById(id);
    }

    public void updateHits(Long id){
        boardRepository.updateHits(id);
    }



    public List<BoardDTO> pagingList(int page) {
        /*
            page=1, 0
            page=2, 3
            page=3, 6
         */
        int pagingStart = (page-1) * PagingConst.PAGE_LIMIT;
        Map<String, Integer> pagingParams = new HashMap<>();
        pagingParams.put("start", pagingStart);
        pagingParams.put("limit", PagingConst.PAGE_LIMIT);
        List<BoardDTO> pagingList = boardRepository.pagingList(pagingParams);
        return pagingList;
    }

    public PageDTO pagingParam(int page) {
        // 전체 글 갯수 조회
        int boardCount = boardRepository.boardCount();
        // 전체 페이지 갯수 계산
        int maxPage = (int) (Math.ceil((double) boardCount / PagingConst.PAGE_LIMIT));
        // 시작 페이지 값 계산(1, 4, 7, 10, ~~~~)
        int startPage = (((int) (Math.ceil((double) page / PagingConst.BLOCK_LIMIT))) - 1) * PagingConst.BLOCK_LIMIT + 1;
        // 끝 페이지 값 계산(3, 6, 9, 12, ~~~~)
        int endPage = startPage + PagingConst.BLOCK_LIMIT - 1;
        if (endPage > maxPage) {
            endPage = maxPage;
        }
        PageDTO pageDTO = new PageDTO();
        pageDTO.setPage(page);
        pageDTO.setMaxPage(maxPage);
        pageDTO.setStartPage(startPage);
        pageDTO.setEndPage(endPage);
        return pageDTO;
    }
}
