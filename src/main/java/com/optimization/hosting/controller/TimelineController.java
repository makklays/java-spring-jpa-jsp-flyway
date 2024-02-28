package com.optimization.hosting.controller;

import com.optimization.hosting.model.Query;
import com.optimization.hosting.model.Timeline;
import com.optimization.hosting.service.QueryServiceImpl;
import com.optimization.hosting.service.TimelineServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TimelineController {
    @Autowired
    TimelineServiceImpl timelineService;
    @Autowired
    QueryServiceImpl queryService;

    @GetMapping("/list-timelines")
    public ModelAndView list_timelines(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("list-timelines");
        mav.addObject("timelines", timelineService.getAllTimelines());
        return mav;
    }

    @GetMapping("/list-timelines-one/{queryId}*")
    public ModelAndView list_timelines_one(@PathVariable Integer queryId, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("list-timeline-one");
        Query query = queryService.getQueryById(queryId);

        List<Timeline> myList = new ArrayList<>();
        if (query.getDateTo() != null) {
            myList = timelineService.getTimelinesByQuery(query.getServiceId(), query.getQuestionTypeId(), query.getDateFrom(), query.getDateTo());
        }

        // get average time
        int sum = 0;
        double averageTime = 0.0;
        if (myList.size() > 0) {
            for (Timeline timeline : myList) {
                sum += timeline.getTime();
            }
            averageTime = (double) sum / myList.size();
        }

        mav.addObject("query", query);
        mav.addObject("timelines", myList);
        mav.addObject("averageTime", averageTime);

        return mav;
    }
}

