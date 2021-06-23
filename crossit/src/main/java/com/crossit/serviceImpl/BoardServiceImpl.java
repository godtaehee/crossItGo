package com.crossit.serviceImpl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crossit.dao.BoardDao;
import com.crossit.domain.BoardDTO;
import com.crossit.paging.PaginationInfo;
import com.crossit.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;

	@Override
	public boolean registerBoard(BoardDTO params) {
		long queryResult = 0;

		if (params.getId() == null) {
			queryResult = boardDao.insertBoard(params);
		} else {
			queryResult = boardDao.updateBoard(params);
		}

		return (queryResult == 1) ? true : false;
	}

	@Override
	public BoardDTO getBoardDetail(Long idx) {
		return boardDao.selectBoardDetail(idx);
	}

	@Override
	public boolean deleteBoard(Long id) {
		long queryResult = 0;

		BoardDTO board = boardDao.selectBoardDetail(id);

		if (board != null && "N".equals(board.getDeleteYn())) {
			queryResult = boardDao.deleteBoard(id);
		}

		return (queryResult == 1) ? true : false;
	}

	@Override
	public List<BoardDTO> getBoardList(BoardDTO boardDTO) {
		List<BoardDTO> boardList = Collections.emptyList();

		long boardTotalCount = boardDao.selectBoardTotalCount(boardDTO);
		

		PaginationInfo paginationInfo = new PaginationInfo(boardDTO);
		paginationInfo.setTotalRecordCount(boardTotalCount);

		boardDTO.setPaginationInfo(paginationInfo);

		if (boardTotalCount > 0) {
			boardList = boardDao.selectBoardList(boardDTO);
		}

		return boardList;
	}


}