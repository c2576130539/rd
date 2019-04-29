package com.cc.rd.dto.shop;

import lombok.Data;

import java.util.List;

/**
 * @program: ShopLabelDTO
 * @description: 商店标签
 * @author: cchen
 * @create: 2019-04-27 10:32
 */
@Data
public class ShopLabelDTO {

    private Long shopId;

    private List<LabelDTO> labelList;
}
