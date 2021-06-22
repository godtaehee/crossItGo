package com.crossit.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crossit.dao.BoardDao;
import com.crossit.entity.Board;
import com.crossit.entity.FileVo;
import com.crossit.entity.IndexView;
import com.crossit.service.BoardService;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	private BoardDao boardDao;

	

	@Override
	public List<IndexView> getList() {

		List<IndexView> list = boardDao.getList();

		return list;
	}

	@Override
	public Board get(int i) {

		Board board = boardDao.get(i);

		return board;
	}


	@Override
	public void boardWirte(Board board) {
		int result = boardDao.insert(board);
	
		
	}

	@Override
	public int fileInsert(FileVo file) {
		
		return boardDao.fileInsert(file);
	}

}