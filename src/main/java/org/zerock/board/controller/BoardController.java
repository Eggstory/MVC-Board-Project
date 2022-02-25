package org.zerock.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.board.service.BoardServiceImpl;
import org.zerock.board.vo.BoardVO;

import com.webjjang.util.PageObject;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board")
@Log4j
public class BoardController {

	@Autowired
	private BoardServiceImpl service;

	private final String MODULE = "board";
	
	// 리스트
	@GetMapping("/list.do")
	public String list(PageObject pageObject, Model model) {

		model.addAttribute("list", service.list(pageObject));
		return MODULE + "/list";
	};

	// 글보기
	@GetMapping("/view.do")
	public String view(Long no, @RequestParam(defaultValue = "0") int inc, Model model,
			@ModelAttribute PageObject pageObject) {
		log.info("no=" + no + ", inc=" + inc);
		model.addAttribute("vo",service.view(no, inc));
		return MODULE + "/view";
	};

	// 글쓰기 폼
	@GetMapping("/write.do")
	public String writeFrom() {
		return MODULE + "/write";
	};

	// 글쓰기 처리
	@PostMapping("/write.do")
	public String write(BoardVO vo, RedirectAttributes rttr) {
		log.info(vo);
		service.write(vo);
		rttr.addFlashAttribute("msg", "게시판 글등록이 되었습니다.");
		return "redirect:list.do";
	};

	// 글수정 폼
	@GetMapping("/update.do")
	public String updateForm(Long no, Model model, @ModelAttribute PageObject pageObject) {
		model.addAttribute("vo",service.view(no, 0));
		return MODULE + "/update";
	};

	// 글수정 처리
	@PostMapping("/update.do")
	public String update(BoardVO vo, RedirectAttributes rttr, PageObject pageObject) {
		log.info(vo);
		service.update(vo);
		rttr.addFlashAttribute("msg", "게시판 글수정이 되었습니다.");
		return "redirect:view.do?no=" + vo.getNo() + "&page=" + pageObject.getPage() 
		+ "&perPageNum=" + pageObject.getPerPageNum();
	};

	// 글삭제
	@GetMapping("/delete.do")
	public String delete(Long no, RedirectAttributes rttr) {
		service.delete(no);
		rttr.addFlashAttribute("msg", "게시판 글삭제가 되었습니다.");
		return "redirect:list.do";
	};

}
