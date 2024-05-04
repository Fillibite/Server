package com.example.hackathon.domain.item.service;

import com.example.hackathon.domain.item.dto.ItemRequestDTO;
import com.example.hackathon.domain.item.dto.ItemResponseDTO;
import com.example.hackathon.domain.item.entity.Item;
import com.example.hackathon.domain.item.entity.Type;
import com.example.hackathon.domain.item.repository.ItemRepository;
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
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final CommonMethod commonMethod;

    @Override
    public ItemResponseDTO.SampleItemFindAllDTO sampleItemFindAll() {
        try {
            log.info("[ItemServiceImpl] sampleItemFindAll");
            // SampleItem을 모두 가져옴
            List<Item> sampleItems = itemRepository.findByItemType(Type.SAMPLE);
            // DTO로 변환
            List<ItemResponseDTO.SampleItemFindOneDTO> sampleItemDTOList = sampleItems.stream()
                    .map(this::mapToSampleItemFindOneDTO)
                    .collect(Collectors.toList());
            // DTO를 SampleItemFindAllDTO에 설정하여 반환
            ItemResponseDTO.SampleItemFindAllDTO dto = new ItemResponseDTO.SampleItemFindAllDTO();
            dto.setSampleList(sampleItemDTOList);
            return dto;
        } catch (Exception e) {
            log.error("[Exception500] ItemServiceImpl sampleItemFindAll", e);
            throw new CustomException(ErrorCode.SERVER_ERROR, "[Exception500] ItemServiceImpl sampleItemFindAll : " + e.getMessage());
        }
    }

    @Override
    public ItemResponseDTO.PackageItemFindAllDTO packageItemFindAll() {
        try {
            log.info("[ItemServiceImpl] packageItemFindAll");
            // PackageItem을 모두 가져옴
            List<Item> packageItems = itemRepository.findByItemType(Type.PACKAGE);
            // DTO로 변환
            List<ItemResponseDTO.PackageItemFindOneDTO> packageItemDTOList = packageItems.stream()
                    .map(this::mapToPackageItemFindOneDTO)
                    .collect(Collectors.toList());
            // DTO를 PackageItemFindAllDTO에 설정하여 반환
            ItemResponseDTO.PackageItemFindAllDTO dto = new ItemResponseDTO.PackageItemFindAllDTO();
            dto.setPackageList(packageItemDTOList);
            return dto;
        } catch (Exception e) {
            log.error("[Exception500] ItemServiceImpl packageItemFindAll", e);
            throw new CustomException(ErrorCode.SERVER_ERROR, "[Exception500] ItemServiceImpl packageItemFindAll : " + e.getMessage());
        }
    }

    @Override
    public ItemResponseDTO.SampleItemSelectAllDTO sampleItemSelectAll(ItemRequestDTO.SampleItemSelectAllDTO sampleItemSelectAllDTO) {
//        try {
//            log.info("[ItemServiceImpl] packageItemFindAll");
//            // PackageItem을 모두 가져옴
//            List<Package> packageItems = packageRepository.findAll();
//            // DTO로 변환
//            List<CartResponseDTO.PackageItemFindOneDTO> packageItemDTOList = packageItems.stream()
//                    .map(this::mapToPackageItemFindOneDTO)
//                    .collect(Collectors.toList());
//            // DTO를 PackageItemFindAllDTO에 설정하여 반환
//            CartResponseDTO.PackageItemFindAllDTO dto = new CartResponseDTO.PackageItemFindAllDTO();
//            dto.setPackageList(packageItemDTOList);
//            return dto;
//        } catch (Exception e) {
//            log.error("[Exception500] ItemServiceImpl packageItemFindAll", e);
//            throw new CustomException(ErrorCode.SERVER_ERROR, "[Exception500] ItemServiceImpl packageItemFindAll : " + e.getMessage());
//        }
        return null;
    }


    // SampleItem을 DTO로 매핑하는 메서드
    private ItemResponseDTO.SampleItemFindOneDTO mapToSampleItemFindOneDTO(Item sampleItem) {
        ItemResponseDTO.SampleItemFindOneDTO dto = new ItemResponseDTO.SampleItemFindOneDTO();
        dto.setId(sampleItem.getId());
        dto.setItemName(sampleItem.getItemName());
        dto.setItemPrice(sampleItem.getItemPrice());
        dto.setItemStock(sampleItem.getItemStock());
        dto.setItemStar(sampleItem.getItemStar());
        dto.setItemReviewCount(sampleItem.getItemReviewCount());
        dto.setItemImg(sampleItem.getItemImg());
        return dto;
    }

    // PackageItem을 DTO로 매핑하는 메서드
    private ItemResponseDTO.PackageItemFindOneDTO mapToPackageItemFindOneDTO(Item packageItem) {
        ItemResponseDTO.PackageItemFindOneDTO dto = new ItemResponseDTO.PackageItemFindOneDTO();
        dto.setId(packageItem.getId());
        dto.setItemName(packageItem.getItemName());
        dto.setItemPrice(packageItem.getItemPrice());
        dto.setItemStock(packageItem.getItemStock());
        dto.setItemStar(packageItem.getItemStar());
        dto.setItemReviewCount(packageItem.getItemReviewCount());
        dto.setItemImg(packageItem.getItemImg());
        return dto;
    }
}
