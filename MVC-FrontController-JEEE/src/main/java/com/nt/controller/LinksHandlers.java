package com.nt.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.nt.service.ILinkService;
import com.nt.service.LinkServiceImpl;

public class LinksHandlers {

	private ILinkService service;

	public LinksHandlers() {
		service = new LinkServiceImpl();
	}

//Handler method 1
	public String showWishMessage(HttpServletRequest req) {

		// use service
		String resultMsg = service.generateWishMessage();

		// keep the result in request scope
		req.setAttribute("wmsg", resultMsg);

		// return logical View name (lvn)base on which Jdp file name and location will
		// be decided
		return "wish_result";

	}

//handler method 2
	public String showAllMessage(HttpServletRequest req) {

		// use service
		Set<String> langSet = service.fetchAllLanguages();

		// keep the result in request scope
		req.setAttribute("langinfo", langSet);

		// return logical view name(lvn)

		return "all_lang";

	}

}
