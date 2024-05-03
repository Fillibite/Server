package com.example.hackathon.domain.cart.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class CartResponseDTO {
    @Setter
    @Getter
    public static class CartFindOneDTO {
        private Long id;
        private String itemName;
        private String itemImg;
        private int itemPrice;
        private int count;
        private int totalPrice;
    }
    @Setter
    @Getter
    public static class CartFindAllDTO {
        private List<CartFindOneDTO> cartList;
    }
}
