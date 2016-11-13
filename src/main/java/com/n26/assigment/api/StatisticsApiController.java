package com.n26.assigment.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.n26.assigment.model.StatisticsData;
import com.n26.assigment.model.Transaction;
import com.n26.assigment.service.StatisticsService;

/**
 * StatisticsApiController represents the end point for the application.
 * For simplicity we will handle any exception at controller not globally.
 * @author Dalia.Kamal
 *
 */
@RestController
public class StatisticsApiController implements HandlerExceptionResolver{

	@Autowired
	private StatisticsService service;
	
	@RequestMapping(method=RequestMethod.POST,path="/transactions")
	@ResponseStatus(HttpStatus.CREATED)
    void addTransaction(@RequestBody Transaction trans) {
		service.addTransaction(trans);
    }
	
	@RequestMapping(method=RequestMethod.GET,path="/statistics")
	StatisticsData getStatistics(){
		return service.getOverallStats();
	}

	@Override
	public ModelAndView resolveException(HttpServletRequest req, HttpServletResponse resp, Object handler,
			Exception ex) {
		 	resp.reset();
	        resp.setCharacterEncoding("UTF-8");
	        resp.setContentType("text/json");
	        resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	        ModelAndView model = new ModelAndView(new MappingJackson2JsonView());
            model.addObject("code", HttpStatus.INTERNAL_SERVER_ERROR.value());
            model.addObject("message", ex.getMessage());
            return model;
	}
}
