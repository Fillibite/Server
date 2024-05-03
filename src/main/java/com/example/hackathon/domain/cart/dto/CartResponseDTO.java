package com.example.hackathon.domain.cart.dto;

import com.example.hackathon.domain.cart.entity.Cart;
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

    @Setter
    @Getter
    public static class CartSelectOneDTO {
        private Long id;
        private String itemName;
        private String itemImg;
        private int itemPrice;
        private int count;
        private int totalPrice;

        public CartSelectOneDTO(Cart cart) {
            this.id = cart.getId();
            this.itemName = cart.getItem().getItemName();
            this.itemImg = cart.getItem().getItemImg();
            this.itemPrice = cart.getItem().getItemPrice();
            this.count = cart.getCount();
            this.totalPrice = cart.getTotalPrice();
        }
    }
    @Setter
    @Getter
    public static class CartSelectAllDTO {
        private List<CartResponseDTO.CartSelectOneDTO> cartSelectList;
    }
}
