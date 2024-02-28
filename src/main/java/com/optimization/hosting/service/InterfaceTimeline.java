package com.optimization.hosting.service;

import com.optimization.hosting.model.Timeline;

import java.util.List;

public interface InterfaceTimeline {
    List<Timeline> getAllTimelines();
    Timeline getTimelineById(Integer id);

    boolean addTimeline(Timeline timeline);
    boolean updateTimeline(Timeline timeline);
    boolean deleteTimeline(Integer id);
}

