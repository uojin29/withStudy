package com.example.withstudy.controller;

import com.example.withstudy.controller.request.BoardRegistRequest;
import com.example.withstudy.controller.response.BoardResponse;
import com.example.withstudy.dto.BoardDto;
import com.example.withstudy.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
@CrossOrigin("*")
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/regist")
    public ResponseEntity<BoardResponse> registBoard(@RequestBody BoardRegistRequest request){
        BoardDto boardDto = boardService.createBoard(BoardDto.from(request));
        BoardResponse boardResponse = new BoardResponse(boardDto);

        return ResponseEntity.ok(boardResponse);
    }
}
