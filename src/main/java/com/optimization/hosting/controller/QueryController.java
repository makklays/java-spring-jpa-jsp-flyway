package com.optimization.hosting.controller;

import com.optimization.hosting.service.QueryServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QueryController {
    @Autowired
    QueryServiceImpl queryService;

    @GetMapping("/list-queries")
    public ModelAndView list_queries(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("list-queries");
        mav.addObject("queries", queryService.getAllQueries());
        return mav;
    }
}

