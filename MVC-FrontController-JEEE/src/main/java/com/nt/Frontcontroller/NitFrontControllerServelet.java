package com.nt.Frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.controller.LinksHandlers;

@WebServlet("/")
public class NitFrontControllerServelet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LinksHandlers handler = null;

	public void init() throws ServletException {
		handler = new LinksHandlers();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("NitFrontCpntrollerServelet.doGet()::" + req.getServletPath());

		// Navigation manegement
		String lnv = null;
		if (req.getServletPath().equalsIgnoreCase("/wish")) {
			lnv = handler.showWishMessage(req);
		} else if (req.getServletPath().equalsIgnoreCase("/lang")) {
			lnv = handler.showAllMessage(req);
		} else
			lnv = "home";
		// view magement
		String destPage = null;
		if (lnv.equalsIgnoreCase("wish_result"))
			destPage = "/show_wish.jsp";
		else if (lnv.equalsIgnoreCase("all_lang"))
			destPage = "/show_language.jsp";
		else
			destPage = "index.jsp";

		// forward the request to dest page

		RequestDispatcher rd = req.getRequestDispatcher(destPage);
		rd.forward(req, resp);
	}
	
	
}
