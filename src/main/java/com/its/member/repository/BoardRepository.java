package com.its.member.repository;

import com.its.member.dto.BoardDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BoardRepository {
    @Autowired
    private SqlSessionTemplate sql;

    public BoardDTO save(BoardDTO boardDTO) {
        System.out.println("insert 전 boardDTO = " + boardDTO);
        sql.insert("Board.save", boardDTO);
        System.out.println("insert 후 boardDTO = " + boardDTO);
        return boardDTO;
    }

    public void saveFileName(BoardDTO boardDTO) {
        sql.insert("Board.saveFile", boardDTO);
    }

    public List<BoardDTO> findAll() {
        return sql.selectList("Board.findAll");
    }

    public BoardDTO findById(Long id) {
        BoardDTO boardDTO = sql.selectOne("Board.findById", id);
        if (boardDTO.getFileAttached() == 1) {
            return sql.selectOne("Board.findByIdFile", id);
        } else {
            return boardDTO;
        }
    }

    public void updateHits(Long id) {
        sql.update("Board.updateHits", id);
    }

    public List<BoardDTO> pagingList(Map<String, Integer> pagingParams) {
        return sql.selectList("Board.pagingList", pagingParams);
    }

    public int boardCount() {
        return sql.selectOne("Board.boardCount");
    }

    public void update(BoardDTO boardDTO) {
        sql.update("Board.update", boardDTO);
    }
}
