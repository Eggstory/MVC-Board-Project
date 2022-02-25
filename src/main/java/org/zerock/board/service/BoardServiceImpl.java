package org.zerock.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.board.mapper.BoardMapper;
import org.zerock.board.vo.BoardVO;

import com.webjjang.util.PageObject;

@Service
public class BoardServiceImpl {
	
	// Mapper 자동 DI 적용
	@Inject
	private BoardMapper mapper;
	
	
	//리스트
	public List<BoardVO> list(PageObject pageObject){
		
		// 페이지 정보 계산
		pageObject.setTotalRow(mapper.getTotalRow(pageObject));
		return mapper.list(pageObject);
	};
	//글보기
	public BoardVO view(Long no, int inc) {
		if(inc == 1) mapper.increase(no);
		return mapper.view(no);
	};
	//글쓰기
	public int write(BoardVO vo) {
		return mapper.write(vo);
	};
	//글수정
	public int update(BoardVO vo) {
		return mapper.update(vo);
	};
	//글삭제
	public int delete(Long no) {
		return mapper.delete(no);
	};

}
