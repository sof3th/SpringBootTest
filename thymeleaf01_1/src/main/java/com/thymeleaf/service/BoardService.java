package com.thymeleaf.service;

import com.thymeleaf.dto.BoardDTO;
import com.thymeleaf.dto.PageRequestDTO;
import com.thymeleaf.dto.PageResultDTO;
import com.thymeleaf.entity.Board;

public interface BoardService {

    Long register(BoardDTO dto);

    PageResultDTO<BoardDTO, Board> getList(PageRequestDTO requestDTO);

    BoardDTO read(Long gno);

    void modify(BoardDTO dto);

    void remove(Long gno);

    default Board dtoToEntity(BoardDTO dto) {
        Board entity = Board.builder()
                .bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();
        return entity;
    }

    default BoardDTO entityToDto(Board entity){

        BoardDTO dto  = BoardDTO.builder()
                .bno(entity.getBno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .regdate(entity.getRegdate())
                .updatedate(entity.getUpdatedate())
                .build();

        return dto;
    }
}
