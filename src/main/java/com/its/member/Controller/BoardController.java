package com.its.member.Controller;

import com.its.member.dto.BoardDTO;
import com.its.member.dto.PageDTO;
import com.its.member.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/save")
    public String save() {
        return "boardPages/boardSave";
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String save(@ModelAttribute BoardDTO boardDTO){
       boolean result = boardService.save(boardDTO);
       if (result) {
           return "redirect:/board/paging?page=";
       } else {
           return "boardPages/saveFail";
       }
    }

    @GetMapping("/")
    public String findAll(Model model) {
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        return "boardPages/boardList";
    }

    @GetMapping
    public String findById(@RequestParam("id") Long id, Model model,
                           @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
       boardService.updateHits(id);
       BoardDTO boardDTO = boardService.findById(id);
       model.addAttribute("board",boardDTO);
       model.addAttribute("page", page);
       return "/boardPages/boardDetail";
    }

    @GetMapping("/paging")
    public String paging(Model model, @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        List<BoardDTO> pagingList = boardService.pagingList(page);
        PageDTO pageDTO = boardService.pagingParam(page);
        model.addAttribute("boardList", pagingList);
        model.addAttribute("paging", pageDTO);
        return "/boardPages/boardList";
    }
}
