package com.example.withstudy.service;

import com.example.withstudy.domain.Board;
import com.example.withstudy.dto.BoardDto;
import com.example.withstudy.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardDto createBoard(BoardDto boardDto) {
        Board board = Board.from(boardDto);

        boardRepository.save(board);
        return BoardDto.from(board);
    }
}
