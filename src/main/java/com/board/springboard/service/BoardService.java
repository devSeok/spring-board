package com.board.springboard.service;


import com.board.springboard.domain.board.Board;
import com.board.springboard.domain.board.BoardRepository;
import com.board.springboard.dto.BoardItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Long save(BoardItemDto boardItemDto) {

        Board board = Board.create(boardItemDto);
        Board save = boardRepository.save(board);

        return save.getId();
    }
}
