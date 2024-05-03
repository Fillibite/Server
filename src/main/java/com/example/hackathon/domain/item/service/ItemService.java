package com.example.hackathon.domain.item.service;

import com.example.hackathon.domain.item.dto.ItemResponseDTO;

public interface ItemService {
    ItemResponseDTO.SampleItemFindAllDTO sampleItemFindAll();
    ItemResponseDTO.PackageItemFindAllDTO packageItemFindAll();
}
