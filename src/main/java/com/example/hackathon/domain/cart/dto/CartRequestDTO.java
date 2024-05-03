package com.example.hackathon.domain.cart.dto;

import com.example.hackathon.domain.cart.entity.Cart;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class CartRequestDTO {
    @Setter
    @Getter
    public static class CartSelectOneDTO {
        private String itemName;
        private String itemImg;
        private int itemPrice;
        private int count;
        private int totalPrice;
    }
    @Setter
    @Getter
    public static class CartSelectAllDTO {
        private List<CartSelectOneDTO> cartSelectList;
    }
}
