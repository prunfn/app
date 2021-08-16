package com.youlai.mall.oms.pojo.vo;

import com.youlai.common.base.BaseVO;
import com.youlai.mall.oms.pojo.dto.OrderItemDTO;
import lombok.Data;

import java.util.List;


@Data
public class OrderConfirmVO extends BaseVO {

    private String orderToken;

    private List<OrderItemDTO> orderItems;

}
