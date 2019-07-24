package com.baizhi.dto;

import com.baizhi.entity.Carousel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarouselPageDto implements Serializable {
    //当前页
    private Integer page;
    //总页数
    private Integer total;
    //总行数
    private Integer records;
    //该页的数据行
    private List<Carousel> rows;
}
