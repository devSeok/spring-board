package com.board.springboard.controllers;

import com.board.springboard.dto.BoardItemDto;
import com.board.springboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final BoardService boardService;

    @GetMapping
    public String index(Model model) {

        return "board/index";
    }

    @GetMapping("/write")
    public String write(Model model) {

        model.addAttribute("item", new BoardItemDto());

        return "board/write";
    }

    @PostMapping("/write")
    public String addWrite(@ModelAttribute BoardItemDto boardItemDto) {

        boardService.save(boardItemDto);

        return "board/index";
    }
}
