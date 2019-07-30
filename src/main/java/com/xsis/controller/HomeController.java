package com.xsis.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home(HttpSession httpSession, HttpServletRequest request) {
		// untuk set session
		//1. menggunakan HttpSession
		// Key = "Username"
		// Value =  "Fullan"
		httpSession.setAttribute("Username", "Fullan");
		
		//2. menggunakan HttpServletRequest
		// Key = "Kota"
		// Value =  "Bekasi"
		request.getSession().setAttribute("Kota", "Bekasi");
		
		// Print session yang telah di register
		// menggunakan HttpSession
		// cetak dengan mengambil keynya "Username"
		System.out.println(httpSession.getAttribute("Username"));
		
		// menggunakan HttpServletRequest
		// cetak dengan mengambil key nya "Kota"
		System.out.println(request.getSession().getAttribute("Kota"));
		
		return "home";
	}
}
