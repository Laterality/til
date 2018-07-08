package kr.latera.guestbook.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.latera.guestbook.dto.Guestbook;
import kr.latera.guestbook.service.GuestbookService;

@Controller
public class GuestbookController {

	@Autowired
	GuestbookService guestbookSerivce;
	
	@GetMapping(path="/list")
	public String list(@RequestParam(name="start", required=false, defaultValue="0") int start,
			ModelMap model) {
		// 방명록 리스트 조회
		List<Guestbook> guestbooks = guestbookSerivce.getGuestbooks(start);
		
		int guestbookCount = guestbookSerivce.getCount();
		int pageCount = guestbookCount / GuestbookService.LIMIT;
		if (guestbookCount % GuestbookService.LIMIT > 0) { pageCount++; }
		
		List<Integer> startList = new ArrayList<>();
		for (int i = 0; i < pageCount; i++) {
			startList.add(i * GuestbookService.LIMIT);
		}
		
		model.addAttribute("guestbooks", guestbooks);
		model.addAttribute("guestbookCount", guestbookCount);
		model.addAttribute("pageStartList", startList);
		
		return "list";
	}
	
	@PostMapping(path="/write")
	public String write(@ModelAttribute Guestbook guestbook, HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();
		System.out.println("clientIp: " + clientIp);
		guestbookSerivce.addGuestbook(guestbook, clientIp);
		
		return "redirect:list";
	}
}
