package com.example.hackathon.domain.item.dto;

import com.example.hackathon.domain.user.entity.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class ItemResponseDTO {
    @Setter
    @Getter
    public static class PackageItemFindOneDTO {
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
    public static class SampleItemFindOneDTO {
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
    public static class PackageItemFindAllDTO {
        private List<ItemResponseDTO.PackageItemFindOneDTO> packageList;
    }
    @Setter
    @Getter
    public static class SampleItemFindAllDTO {
        private List<ItemResponseDTO.SampleItemFindOneDTO> sampleList;
    }
}
