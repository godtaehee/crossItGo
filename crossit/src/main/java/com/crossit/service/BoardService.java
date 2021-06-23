package com.crossit.service;

import java.util.List;

import com.crossit.domain.BoardDTO;
import com.crossit.paging.Criteria;

public interface BoardService {

	public boolean registerBoard(BoardDTO params);

	public BoardDTO getBoardDetail(Long idx);

	public boolean deleteBoard(Long idx);

	public List<BoardDTO> getBoardList(BoardDTO boardDTO);

}