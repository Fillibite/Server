package com.example.hackathon.domain.item.dto;

import com.example.hackathon.domain.item.entity.Item;
import com.example.hackathon.domain.item.entity.Type;
import com.example.hackathon.domain.user.entity.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

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
    public static class PackageItemFindAllDTO {
        private List<ItemResponseDTO.PackageItemFindOneDTO> packageList;
    }
    @Setter
    @Getter
    public static class SampleItemFindAllDTO {
        private List<ItemResponseDTO.SampleItemFindOneDTO> sampleList;
    }

    @Setter
    @Getter
    public static class SampleItemSelectAllDTO {
        private List<ItemRequestDTO.SampleItemSelectOneDTO> sampleList;
    }

    @Setter
    @Getter
    public static class ItemFindOneDTO {
        private Long id;
        private String itemName;
        private int itemPrice;
        private int itemStock;
        private float itemStar;
        private int itemReviewCount;
        private String itemImg;
        private Type itemType;

        public ItemFindOneDTO(Item item) {
            this.id = item.getId();
            this.itemName = item.getItemName();
            this.itemPrice = item.getItemPrice();
            this.itemStock = item.getItemStock();
            this.itemStar = item.getItemStar();
            this.itemReviewCount = item.getItemReviewCount();
            this.itemImg = item.getItemImg();
            this.itemType = item.getItemType();
        }
    }

    @Setter
    @Getter
    public static class ItemSearch {
        private List<ItemResponseDTO.ItemFindOneDTO> searchList;
    }

//    @Setter
//    @Getter
//    public static class Top3FindAllDTO {
//        private List<ItemResponseDTO.ItemFindOneDTO> top3List;
//
//        public Top3FindAllDTO(List<ItemFindOneDTO> top3ItemList) {
//            this.top3List = top3ItemList;
//        }
//    }
//    @Setter
//    @Getter
//    public static class RecentlyFindAllDTO {
//        private List<ItemResponseDTO.ItemFindOneDTO> recentlyList;
//
//        public RecentlyFindAllDTO(List<ItemFindOneDTO> recentlyItemList) {
//            this.recentlyList = recentlyItemList;
//        }
//    }
}
