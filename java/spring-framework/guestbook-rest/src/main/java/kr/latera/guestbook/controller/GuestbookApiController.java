package kr.latera.guestbook.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.latera.guestbook.dto.Guestbook;
import kr.latera.guestbook.service.GuestbookService;

@RestController
@RequestMapping(path="/guestbooks")
public class GuestbookApiController {

	@Autowired
	GuestbookService guestbookService;
	
	/**
	 * 방명록 리스트를 응답으로 반환한다.
	 * 
	 */
	@GetMapping
	public Map<String, Object> list(@RequestParam(name="start", required=false, defaultValue="0") int start) {
		List<Guestbook> list = guestbookService.getGuestbooks(start);
		
		int count = guestbookService.getCount();
		int pageCount = count/GuestbookService.LIMIT;
		if(count % GuestbookService.LIMIT > 0) { pageCount++; }
		
		List<Integer> pageStartList = new ArrayList<>();
		for (int i = 0; i < pageCount; i++) {
			pageStartList.add(i * guestbookService.LIMIT);
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("guestbooks", list);
		map.put("count", count);
		map.put("pageStartList", pageStartList);
		
		// Map 객체를 반환하면 Spring에서 jackson을 이용해서 JSON 객체로 변환해서 응답한다.
		return map;
	}
	
	/**
	 * 인자에 @RequestBody가 붙은 객체가 있으면 요청 JSON을 해당 객체로 변환해준다.
	 * 
	 */
	@PostMapping
	public Guestbook write(@RequestBody Guestbook guestbook, HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();
		Guestbook createdGuestbook = guestbookService.addGuestbook(guestbook, clientIp);
		
		return createdGuestbook;
	}
	
	@DeleteMapping
	public Map<String, String> delete(@PathVariable(name="id") Long id, HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();
		
		int deleteCount = guestbookService.deleteGuestbook(id, clientIp);
		return Collections.singletonMap("success", deleteCount > 0 ? "true" : "false");
	}
}
