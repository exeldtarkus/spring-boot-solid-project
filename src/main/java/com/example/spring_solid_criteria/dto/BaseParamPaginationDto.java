package com.example.spring_solid_criteria.dto;

public class BaseParamPaginationDto extends BaseParamsDto {
    private Integer limit = 0;
    private Integer offset = 0;

    public BaseParamPaginationDto() {}

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
