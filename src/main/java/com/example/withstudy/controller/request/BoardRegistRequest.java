package com.example.withstudy.controller.request;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Data
public class BoardRegistRequest {
    private String title;
    private String cont;
}
