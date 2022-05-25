package com.board.springboard.domain.board;

import com.board.springboard.domain.base.BaseTimeEntity;
import com.board.springboard.dto.BoardItemDto;
import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 30, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;


    public static Board create(BoardItemDto boardItemDto) {
        return Board.builder()
                .name(boardItemDto.getName())
                .title(boardItemDto.getTitle())
                .content(boardItemDto.getContent())
                .build();
    }
}
