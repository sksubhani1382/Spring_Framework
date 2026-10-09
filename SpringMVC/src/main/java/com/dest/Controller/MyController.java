package com.dest.Controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/myctrl")
public class MyController {
	
	@RequestMapping(value="/hello" , method =RequestMethod.GET)
	public ModelAndView hello(HttpServletRequest req,HttpServletResponse res)
	{
		String name=req.getParameter("name");
		ModelAndView modelAndView=new ModelAndView("index");
		modelAndView.addObject("message","Hi Destination...!"+new Date());
		modelAndView.addObject("date","My name is"+name);
		
		return modelAndView;
	}
}

