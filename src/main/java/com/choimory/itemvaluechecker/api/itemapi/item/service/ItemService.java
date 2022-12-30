package com.choimory.itemvaluechecker.api.itemapi.item.service;

import com.choimory.itemvaluechecker.api.itemapi.common.exception.CommonException;
import com.choimory.itemvaluechecker.api.itemapi.item.data.dto.ItemDto;
import com.choimory.itemvaluechecker.api.itemapi.item.data.request.RequestItemRegister;
import com.choimory.itemvaluechecker.api.itemapi.item.data.request.RequestItemFindAll;
import com.choimory.itemvaluechecker.api.itemapi.item.data.response.ResponseItemRegister;
import com.choimory.itemvaluechecker.api.itemapi.item.data.response.ResponseItemFindAll;
import com.choimory.itemvaluechecker.api.itemapi.item.data.response.ResponseItemFind;
import com.choimory.itemvaluechecker.api.itemapi.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public ResponseItemFind find(final Long id){
        return ResponseItemFind.builder()
                .item(ItemDto.toDto(itemRepository.findById(id)
                        .orElseThrow(() -> new CommonException(HttpStatus.NO_CONTENT,
                                HttpStatus.NO_CONTENT.value(),
                                HttpStatus.NO_CONTENT.getReasonPhrase()))))
                .build();
    }

    public ResponseItemFindAll findAll(final RequestItemFindAll param){
        return null;
    }

    public ResponseItemRegister register(final RequestItemRegister param){
        return null;
    }
}
