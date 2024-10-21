package com.mightyjava.controller;

import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class IndexController implements ErrorController {
	private static final String PATH = "/error";

	private final ErrorAttributes errorAttributes;

	public IndexController(ErrorAttributes errorAttributes) {
		this.errorAttributes = errorAttributes;
	}

	public String getErrorPath() {
		return PATH;
	}

	@RequestMapping(PATH)
	public String error(HttpServletRequest request) {
		return "No Mapping available.";
	}
}
