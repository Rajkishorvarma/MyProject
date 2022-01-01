package com.raj.search;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
@Controller
public class SearchController {
	@RequestMapping("/home")
	public String home() {
		System.out.println("gone to home....");
		return "home";
	}
	@RequestMapping("/search")
	public RedirectView search(@RequestParam("querybox")String query) {
		String uri="https://www.google.com/search?q="+query;
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(uri);
		return redirectView;
	}
}
