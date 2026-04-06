package com.example.withstudy.dto;

import com.example.withstudy.controller.request.BoardRegistRequest;
import com.example.withstudy.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class BoardDto {
    private Long id;
    private String title;
    private String cont;
    private Long member_id;

    public static BoardDto from(BoardRegistRequest boardRegistRequest){
        return BoardDto.builder()
                .title(boardRegistRequest.getTitle())
                .cont(boardRegistRequest.getCont())
                .build();
    }

    public static BoardDto from(Board board){
        return BoardDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .cont(board.getCont())
                .build();
    }
}
