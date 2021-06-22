package com.crossit.serviceImpl;

import java.util.List;
import java.util.Map;

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

	//파일 업로드 추가 
	//글의 정보를 저장한 후에,글 번호를 가져온다. 
	@Override
	public int addNewArticle(Map articleMap) throws Exception {
		//글 정보를 저장한다. 
		int articleNo =boardDao.insert(articleMap);
		//글 번호를 articlMap에 저장한 후에 
		articleMap.put("articleNo", articleNo);
		//글 이미지 정보를 저장한다. 
		boardDao.fileInsert(articleMap);
		
		return articleNO;
	}

}