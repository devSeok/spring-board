package com.board.springboard.domain.board;

import com.board.springboard.dto.BoardItemDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.board.springboard.domain.board.QBoard.board;

@Repository
@RequiredArgsConstructor
public class BoardQueryRepository {
    private final JPAQueryFactory jpaQueryFactory;

    public List<BoardItemDto> getList() {
        return jpaQueryFactory
                .select(Projections.constructor(
                        BoardItemDto.class,
                        board.title,
                        board.name,
                        board.content
                ))
                .from(board)
                .fetch();
    }
}
