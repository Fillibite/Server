package com.example.hackathon.domain.item.service;

import com.example.hackathon.domain.item.dto.ItemRequestDTO;
import com.example.hackathon.domain.item.dto.ItemResponseDTO;

public interface ItemService {
    ItemResponseDTO.ItemFindOneDTO findOne(Long itemId);
    ItemResponseDTO.SampleItemFindAllDTO sampleItemFindAll();
    ItemResponseDTO.PackageItemFindAllDTO packageItemFindAll();
//    ItemResponseDTO.Top3FindAllDTO top3FindAll();
//    ItemResponseDTO.RecentlyFindAllDTO recentlyFindAll();
    ItemResponseDTO.SampleItemSelectAllDTO sampleItemSelectAll(ItemRequestDTO.SampleItemSelectAllDTO sampleItemSelectAllDTO);
    ItemResponseDTO.ItemSearch searchKeyWord(ItemRequestDTO.ItemSearchDTO itemSearchDTO);
}
