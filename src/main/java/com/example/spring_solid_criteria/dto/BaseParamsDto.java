package com.example.spring_solid_criteria.dto;

import java.util.List;

public class BaseParamsDto {
    private List<String> selected;

    public BaseParamsDto() {}

    public List<String> getSelected() {
        return selected;
    }

    public void setSelected(List<String> selected) {
        this.selected = selected;
    }
}
