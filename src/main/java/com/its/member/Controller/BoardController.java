package com.its.member.Controller;

import com.its.member.dto.BoardDTO;
import com.its.member.dto.CommentDTO;
import com.its.member.dto.PageDTO;
import com.its.member.service.BoardService;
import com.its.member.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/save")
    public String save() {
        return "boardPages/boardSave";
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String save(@ModelAttribute BoardDTO boardDTO) throws IOException {
       boardService.save(boardDTO);
       return "redirect:/board/";
    }

    @GetMapping("/")
    public String findAll(Model model) {
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        return "boardPages/boardPaging";
    }

    @GetMapping
    public String findById(@RequestParam("id") Long id, Model model,
                           @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
       boardService.updateHits(id);
       BoardDTO boardDTO = boardService.findById(id);
       model.addAttribute("board",boardDTO);
       model.addAttribute("page", page);
       System.out.println("조회: boardDTO="+boardDTO);
       List<CommentDTO> commentDTOList = commentService.findAll(id);
       model.addAttribute("commentList", commentDTOList);
       return "/boardPages/boardDetail";
    }

    @GetMapping("/paging")
    public String paging(Model model, @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        List<BoardDTO> pagingList = boardService.pagingList(page);
        PageDTO pageDTO = boardService.pagingParam(page);
        model.addAttribute("boardList", pagingList);
        model.addAttribute("paging", pageDTO);
        return "boardPages/boardPaging";
    }

    @GetMapping("/update")
    public String updateForm(@RequestParam("id") Long id, Model model){
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        return "boardPages/boardUpdate";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute BoardDTO boardDTO, Model model) {
        boardService.update(boardDTO);
        BoardDTO dto = boardService.findById(boardDTO.getId());
        model.addAttribute("board", dto);
        return "boardPages/boardDetail";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id){
        boardService.delete(id);
        return "redirect:/board/";
    }
}
