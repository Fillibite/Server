package com.example.hackathon.domain.cart.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class CartRequestDTO {
    @Setter
    @Getter
    public static class SampleItemSelectOneDTO {
        private Long id;
        private String itemName;
        private int itemPrice;
        private int itemStock;
        private float itemStar;
        private int itemReviewCount;
        private String itemImg;
    }
    @Setter
    @Getter
    public static class SampleItemSelectAllDTO {
        private List<SampleItemSelectOneDTO> sampleList;
    }
}
