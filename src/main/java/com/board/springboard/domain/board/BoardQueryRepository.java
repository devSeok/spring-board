package com.board.springboard.domain.board;

import com.board.springboard.dto.BoardItemDto;
import com.board.springboard.dto.BoardListDto;
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

    public List<BoardListDto> getList() {
        return jpaQueryFactory
                .select(Projections.constructor(
                        BoardListDto.class,
                        board.id,
                        board.name,
                        board.title,
                        board.createdDate
                ))
                .from(board)
                .fetch();
    }
}
