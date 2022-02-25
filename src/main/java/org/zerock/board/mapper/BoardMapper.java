package org.zerock.board.mapper;

import java.util.List;

import org.zerock.board.vo.BoardVO;

import com.webjjang.util.PageObject;

public interface BoardMapper {
		
	
	//리스트
	public List<BoardVO> list(PageObject pageObject);
	//리스트 페이지 처리를 위한 전체 데이터 갯수
	public Long getTotalRow(PageObject pageObject);
	//글보기
	public BoardVO view(Long no);
	//조회수 1증가
	public int increase(Long no);
	//글쓰기
	public int write(BoardVO vo);
	//글수정
	public int update(BoardVO vo);
	//글삭제
	public int delete(Long no);
	
}
