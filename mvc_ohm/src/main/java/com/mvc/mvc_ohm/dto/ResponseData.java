package com.mvc.mvc_ohm.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mvc.mvc_ohm.entity.DataCPUEntity;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseData {

    @JsonProperty("data_top_15")
    private List<DataCPUEntity> data ;
    private String code;
    private String status;
    private String detail;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public List<DataCPUEntity> getData() {
        return data;
    }

    public void setData(List<DataCPUEntity> data) {
        this.data = data;
    }
}
