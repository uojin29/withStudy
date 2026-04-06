package com.example.withstudy.controller.response;

import com.example.withstudy.dto.BoardDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardResponse {
    private Long id;
    private String title;
    private String cont;

    public BoardResponse(BoardDto boardDto){
        this.title = boardDto.getTitle();
        this.cont = boardDto.getCont();
    }
}
