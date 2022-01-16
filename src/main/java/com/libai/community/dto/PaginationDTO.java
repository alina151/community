package com.libai.community.dto;

import com.libai.community.model.Question;
import lombok.Data;

import java.util.List;
@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private Boolean showPrevious;
    private Boolean showNext;
    private Boolean showFirstPage;
    private Boolean showEndPage;

    private Integer page;
    private List<Integer> pages;



    public void setPagenation(Integer totalCount, Integer page, Integer size) {
        Integer totalPage = 0;
        if(totalCount % size == 0) {
            totalPage = totalCount / size;
        }else {
            totalPage = totalCount / size + 1;
        }

    }
}
