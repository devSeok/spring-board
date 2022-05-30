package com.board.springboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class BoardListDto {
    private Long id;
    private String name;
    private String title;
    private LocalDateTime create_date;
}
