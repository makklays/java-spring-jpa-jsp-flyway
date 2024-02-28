package com.optimization.hosting.service;

import com.optimization.hosting.model.Timeline;
import com.optimization.hosting.repository.TimelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Service
public class TimelineServiceImpl implements InterfaceTimeline {

    @Lazy
    @Autowired
    private TimelineRepository timelineRepository;

    @Override
    public List<Timeline> getAllTimelines() {
        List<Timeline> list = new ArrayList<>();
        timelineRepository.findAll().forEach(list::add);

        return list;
    }

    public List<Timeline> getTimelinesByQuery(Integer serviceId, Integer questionTypeId, Timestamp dateFrom, Timestamp dateTo) {
        List<Timeline> list = new ArrayList<>();
        //timelineRepository.findByServiceIdAndCategoryIdAndDateBetween(serviceId, categoryId, dateFrom, dateTo).forEach(list::add);
        timelineRepository.findByDateBetween(dateFrom, dateTo).forEach(list::add);

        if (list.size() > 0) {
            Iterator<Timeline> it = list.iterator();

            while (it.hasNext()) {
                Timeline timeline = it.next();
                if (serviceId != null) {
                    if (timeline.getServiceId() != null && !Objects.equals(timeline.getServiceId(), serviceId)) {
                        it.remove();
                    }
                }
                if (questionTypeId != null) {
                    if (timeline.getQuestionTypeId() != null && !Objects.equals(timeline.getQuestionTypeId(), questionTypeId)) {
                        if (it.hasNext()) { // remove it above
                            it.remove();
                        }
                    }
                }
            }
        }

        return list;
    }

    @Override
    public Timeline getTimelineById(Integer id) {
        return timelineRepository.getById(id);
    }

    @Override
    public boolean addTimeline(Timeline timeline) {
        Timeline t = timelineRepository.save(timeline);
        if (t.getId() > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateTimeline(Timeline timeline) {
        Timeline t = timelineRepository.save(timeline);
        if (t.getId() > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteTimeline(Integer id) {
        Timeline timeline = timelineRepository.getById(id);
        if (timeline.getId() > 0) {
            timelineRepository.delete(timeline);
            return true;
        } else {
            return false;
        }
    }
}

