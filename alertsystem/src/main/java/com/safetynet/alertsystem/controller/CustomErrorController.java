package com.safetynet.alertsystem.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomErrorController implements ErrorController {
	
	private static final Logger logger = LogManager.getLogger("CustomError");

	@Override
	public String getErrorPath() {
		return "/error";
	}
	
	@GetMapping("/error")
	public ModelAndView handleError(HttpServletResponse response) {
		int code = response.getStatus();
		
		logger.error("Error with the code {} happened! damn...", code);
		
		return new ModelAndView("error");
	}

}
