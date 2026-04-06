package com.example.withstudy.domain;

import com.example.withstudy.dto.BoardDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String cont;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public static Board from(BoardDto boardDto){
        return Board.builder()
                .title(boardDto.getTitle())
                .cont(boardDto.getCont())
                .build();
    }
}
