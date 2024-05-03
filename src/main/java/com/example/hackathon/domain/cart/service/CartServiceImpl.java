package com.example.hackathon.domain.cart.service;

import com.example.hackathon.domain.cart.dto.CartResponseDTO;
import com.example.hackathon.domain.cart.entity.Cart;
import com.example.hackathon.domain.cart.repository.CartRepository;
import com.example.hackathon.domain.item.dto.ItemResponseDTO;
import com.example.hackathon.domain.item.entity.Sample;
import com.example.hackathon.global.common.CommonMethod;
import com.example.hackathon.global.common.exception.CustomException;
import com.example.hackathon.global.common.reponse.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class CartServiceImpl implements CartService {
    private final CommonMethod commonMethod;
    private final CartRepository cartRepository;

    @Override
    public CartResponseDTO.CartFindAllDTO cartFindAll(String userEmail) {
        try {
            log.info("[CartServiceImpl] cartFindAll");
            // SampleItem을 모두 가져옴
            List<Cart> cartList = cartRepository.findAll();
            // DTO로 변환
            List<CartResponseDTO.CartFindOneDTO> cartFindOneDTO = cartList.stream()
                    .map(this::mapToCartFindOneDTO)
                    .collect(Collectors.toList());
            // DTO를 SampleItemFindAllDTO에 설정하여 반환
            CartResponseDTO.CartFindAllDTO dto = new CartResponseDTO.CartFindAllDTO();
            dto.setCartList(cartFindOneDTO);
            return dto;
        } catch (Exception e) {
            log.error("[Exception500] CartServiceImpl cartFindAll", e);
            throw new CustomException(ErrorCode.SERVER_ERROR, "[Exception500] CartServiceImpl cartFindAll : " + e.getMessage());
        }
    }

    private CartResponseDTO.CartFindOneDTO mapToCartFindOneDTO(Cart cart) {
        CartResponseDTO.CartFindOneDTO dto = new CartResponseDTO.CartFindOneDTO();
        dto.setId(cart.getId());
        dto.setItemName(cart.getItem().getItemName());
        dto.setItemPrice(cart.getItem().getItemPrice());
        dto.setCount(cart.getCount());
        dto.setTotalPrice(cart.getTotalPrice());
        dto.setItemImg(cart.getItem().getItemImg());
        return dto;
    }
}
