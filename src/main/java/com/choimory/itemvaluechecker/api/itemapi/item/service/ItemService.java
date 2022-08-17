package com.choimory.itemvaluechecker.api.itemapi.item.service;

import com.choimory.itemvaluechecker.api.itemapi.common.exception.CommonException;
import com.choimory.itemvaluechecker.api.itemapi.item.dto.dto.ItemDto;
import com.choimory.itemvaluechecker.api.itemapi.item.dto.request.ItemRegistRequest;
import com.choimory.itemvaluechecker.api.itemapi.item.dto.request.ItemViewAllRequest;
import com.choimory.itemvaluechecker.api.itemapi.item.dto.response.ItemRegistResponse;
import com.choimory.itemvaluechecker.api.itemapi.item.dto.response.ItemViewAllResponse;
import com.choimory.itemvaluechecker.api.itemapi.item.dto.response.ItemViewResponse;
import com.choimory.itemvaluechecker.api.itemapi.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemViewResponse view(final Long id){
        return ItemViewResponse.builder()
                .item(ItemDto.toDto(itemRepository.findById(id)
                        .orElseThrow(() -> new CommonException(HttpStatus.NO_CONTENT,
                                HttpStatus.NO_CONTENT.value(),
                                HttpStatus.NO_CONTENT.getReasonPhrase()))))
                .build();
    }

    public ItemViewAllResponse viewAll(final ItemViewAllRequest param){
        return null;
    }

    public ItemRegistResponse regist(final ItemRegistRequest param){
        return null;
    }
}
