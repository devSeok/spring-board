package com.board.springboard.service;


import com.board.springboard.domain.board.Board;
import com.board.springboard.domain.board.BoardQueryRepository;
import com.board.springboard.domain.board.BoardRepository;
import com.board.springboard.domain.board.QBoard;
import com.board.springboard.dto.BoardItemDto;
import com.board.springboard.dto.BoardListDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.expression.spel.ast.Projection;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final BoardQueryRepository boardQueryRepository;

    public List<BoardListDto> getList() {

        return boardQueryRepository.getList();
    }

    public Long save(BoardItemDto boardItemDto) {

        Board board = Board.create(boardItemDto);
        Board save = boardRepository.save(board);

        return save.getId();
    }
}
