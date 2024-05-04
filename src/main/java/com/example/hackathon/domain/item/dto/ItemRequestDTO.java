package com.example.hackathon.domain.item.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class ItemRequestDTO {
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
        private List<ItemRequestDTO.SampleItemSelectOneDTO> sampleList;
    }

    @Setter
    @Getter
    public static class ItemSearchDTO {
        private String searchKeyWord;
    }
}
