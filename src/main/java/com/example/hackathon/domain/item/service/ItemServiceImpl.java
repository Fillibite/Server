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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final CommonMethod commonMethod;

    @Override
    public ItemResponseDTO.ItemFindOneDTO findOne(Long itemId) {
        try {
            log.info("[ItemServiceImpl] findOne");
            Optional<Item> findItem = itemRepository.findById(itemId);
            if(!findItem.isPresent()) {
                throw new CustomException(ErrorCode.ITEM_NOT_FOUND);
            }
            return new ItemResponseDTO.ItemFindOneDTO(findItem.get());

        } catch (CustomException ce){
            log.info("[CustomException] ItemServiceImpl findOne");
            throw ce;
        } catch (Exception e){
            log.info("[Exception500] ItemServiceImpl findOne");
            throw new CustomException(ErrorCode.SERVER_ERROR, "[Exception500] ItemServiceImpl findOne : " + e.getMessage());
        }
    }

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
        } catch (CustomException ce){
            log.info("[CustomException] ItemServiceImpl sampleItemFindAll");
            throw ce;
        } catch (Exception e){
            log.info("[Exception500] ItemServiceImpl sampleItemFindAll");
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
        } catch (CustomException ce){
            log.info("[CustomException] ItemServiceImpl packageItemFindAll");
            throw ce;
        } catch (Exception e){
            log.info("[Exception500] ItemServiceImpl packageItemFindAll");
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

    @Override
    public ItemResponseDTO.ItemSearch searchKeyWord(ItemRequestDTO.ItemSearchDTO itemSearchDTO) {
        try {
            log.info("[ItemServiceImpl] searchKeyWord");
            String searchKeyWord = itemSearchDTO.getSearchKeyWord();
            List<Item> result = itemRepository.findByItemNameContaining(searchKeyWord);

            List<ItemResponseDTO.ItemFindOneDTO> searchResult = result.stream()
                    .map(ItemResponseDTO.ItemFindOneDTO::new)
                    .collect(Collectors.toList());

            ItemResponseDTO.ItemSearch itemSearch = new ItemResponseDTO.ItemSearch();
            itemSearch.setSearchList(searchResult);

            return itemSearch;

        } catch (CustomException ce) {
            log.info("[CustomException] ItemServiceImpl searchKeyWord");
            throw ce;
        } catch (Exception e) {
            log.info("[Exception500] ItemServiceImpl searchKeyWord");
            throw new CustomException(ErrorCode.SERVER_ERROR, "[Exception500] ItemServiceImpl searchKeyWord : " + e.getMessage());
        }
    }

//    @Override
//    public ItemResponseDTO.Top3FindAllDTO top3FindAll() {
//        try {
//            log.info("[ItemServiceImpl] top3FindAll");
//            Pageable pageable = PageRequest.of(0, 3); // 페이지 번호는 0부터 시작하고, 크기는 3
//            Page<Item> top3Items = itemRepository.findAllByOrderByItemReviewCountDesc(pageable);
//            List<ItemResponseDTO.ItemFindOneDTO> top3ItemList = top3Items.getContent().stream()
//                    .map(ItemResponseDTO.ItemFindOneDTO::new)
//                    .collect(Collectors.toList());
//            return new ItemResponseDTO.Top3FindAllDTO(top3ItemList);
//        } catch (CustomException ce) {
//            log.info("[CustomException] ItemServiceImpl top3FindAll");
//            throw ce;
//        } catch (Exception e) {
//            log.info("[Exception500] ItemServiceImpl top3FindAll");
//            throw new CustomException(ErrorCode.SERVER_ERROR, "[Exception500] ItemServiceImpl top3FindAll : " + e.getMessage());
//        }
//    }
//    @Override
//    public ItemResponseDTO.RecentlyFindAllDTO recentlyFindAll() {
//        try {
//            log.info("[ItemServiceImpl] recentlyFindAll");
//            Pageable pageable = PageRequest.of(0, 3); // 페이지 번호는 0부터 시작하고, 크기는 3
//            Page<Item> recentlyItems = itemRepository.findAllByOrderByCreatedTimeDesc(pageable);
//            List<ItemResponseDTO.ItemFindOneDTO> recentlyItemList = recentlyItems.getContent().stream()
//                    .map(ItemResponseDTO.ItemFindOneDTO::new)
//                    .collect(Collectors.toList());
//            return new ItemResponseDTO.RecentlyFindAllDTO(recentlyItemList);
//        } catch (CustomException ce) {
//            log.info("[CustomException] ItemServiceImpl recentlyFindAll");
//            throw ce;
//        } catch (Exception e) {
//            log.info("[Exception500] ItemServiceImpl recentlyFindAll");
//            throw new CustomException(ErrorCode.SERVER_ERROR, "[Exception500] ItemServiceImpl recentlyFindAll : " + e.getMessage());
//        }
//    }

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
