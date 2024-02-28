package com.optimization.hosting.repository;

import com.optimization.hosting.model.Timeline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface TimelineRepository extends JpaRepository<Timeline, Long> {

    Timeline getById(Integer id);
    List<Timeline> findByServiceId(Integer serviceId);
    List<Timeline> findByQuestionTypeId(Integer questionTypeId);
    List<Timeline> findByServiceIdAndCategoryIdAndDateBetween(Integer serviceId, Integer questionTypeId, Timestamp dateFrom, Timestamp dateTo);

    List<Timeline> findByDateBetween(Timestamp dateFrom, Timestamp dateTo);

    @Query(nativeQuery = true, value = "SELECT * FROM `timelines` t WHERE (date BETWEEN :dateFrom AND :dateTo) ORDER BY `date` DESC LIMIT :limit ")
    List<Timeline> getTimelinesByDateBetweenAndMyLimit(@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo, @Param("limit") int limit);
}

