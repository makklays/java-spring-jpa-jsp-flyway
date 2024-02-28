package com.optimization.hosting.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "timelines")
public class Timeline {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "timelines_seq")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "service_id", nullable = true)
    private Integer serviceId;

    @Column(name = "variation_id", nullable = true)
    private Integer variationId;

    @Column(name = "question_type_id", nullable = true)
    private Integer questionTypeId;

    @Column(name = "category_id", nullable = true)
    private Integer categoryId;

    @Column(name = "sub_category_id", nullable = true)
    private Integer subCategoryId;

    @Column(name = "response_type", columnDefinition="ENUM('P','N')", nullable = false)
    @Enumerated(EnumType.STRING)
    private ResponseType responseType;

    public enum ResponseType {
        P, N
    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", nullable = false)
    private Timestamp date;

    @Column(name = "time", nullable = false) // minutes
    private Integer time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getVariationId() {
        return variationId;
    }

    public void setVariationId(Integer variationId) {
        this.variationId = variationId;
    }

    public Integer getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(Integer questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Integer subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public ResponseType getResponseType() {
        return responseType;
    }

    public void setResponseType(ResponseType responseType) {
        this.responseType = responseType;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Timeline timeline)) return false;
        return getId() == timeline.getId() && getServiceId().equals(timeline.getServiceId()) && getVariationId().equals(timeline.getVariationId()) && getQuestionTypeId().equals(timeline.getQuestionTypeId()) && getCategoryId().equals(timeline.getCategoryId()) && getSubCategoryId().equals(timeline.getSubCategoryId()) && getResponseType() == timeline.getResponseType() && getDate().equals(timeline.getDate()) && getTime().equals(timeline.getTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getServiceId(), getVariationId(), getQuestionTypeId(), getCategoryId(), getSubCategoryId(), getResponseType(), getDate(), getTime());
    }

    @Override
    public String toString() {
        return "Timeline{" +
                "id=" + id +
                ", serviceId=" + serviceId +
                ", variationId=" + variationId +
                ", questionTypeId=" + questionTypeId +
                ", categoryId=" + categoryId +
                ", subCategoryId=" + subCategoryId +
                ", responseType=" + responseType +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}

