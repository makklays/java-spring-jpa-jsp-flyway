package com.optimization.hosting.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "queries")
public class Query {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "queries_seq")
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
    private Timeline.ResponseType responseType;

    public enum ResponseType {
        P, N
    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_from", nullable = false)
    private Timestamp dateFrom;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_to", nullable = true)
    private Timestamp dateTo;

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

    public Timeline.ResponseType getResponseType() {
        return responseType;
    }

    public void setResponseType(Timeline.ResponseType responseType) {
        this.responseType = responseType;
    }

    public Timestamp getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Timestamp dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Timestamp getDateTo() {
        return dateTo;
    }

    public void setDateTo(Timestamp dateTo) {
        this.dateTo = dateTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Query query)) return false;
        return getId() == query.getId() && getServiceId().equals(query.getServiceId()) && getVariationId().equals(query.getVariationId()) && getQuestionTypeId().equals(query.getQuestionTypeId()) && getCategoryId().equals(query.getCategoryId()) && getSubCategoryId().equals(query.getSubCategoryId()) && getResponseType() == query.getResponseType() && getDateFrom().equals(query.getDateFrom()) && getDateTo().equals(query.getDateTo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getServiceId(), getVariationId(), getQuestionTypeId(), getCategoryId(), getSubCategoryId(), getResponseType(), getDateFrom(), getDateTo());
    }

    @Override
    public String toString() {
        return "Query{" +
                "id=" + id +
                ", serviceId=" + serviceId +
                ", variationId=" + variationId +
                ", questionTypeId=" + questionTypeId +
                ", categoryId=" + categoryId +
                ", subCategoryId=" + subCategoryId +
                ", responseType=" + responseType +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                '}';
    }
}

