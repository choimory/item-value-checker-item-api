package com.choimory.itemvaluechecker.api.itemapi.item.controller;

import com.choimory.itemvaluechecker.api.itemapi.item.dto.request.ItemRegistRequest;
import com.choimory.itemvaluechecker.api.itemapi.item.dto.request.ItemViewAllRequest;
import com.choimory.itemvaluechecker.api.itemapi.item.dto.response.ItemRegistResponse;
import com.choimory.itemvaluechecker.api.itemapi.item.dto.response.ItemViewAllResponse;
import com.choimory.itemvaluechecker.api.itemapi.item.dto.response.ItemViewResponse;
import com.choimory.itemvaluechecker.api.itemapi.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
@Validated
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/{id}")
    public ItemViewResponse view(@PathVariable
                                     @Valid
                                     @Min(value = 1)
                                     @Digits(integer = Integer.MAX_VALUE /*2147483647*/, fraction = 0)
                                     final Long id){
        return itemService.view(id);
    }

    @PostMapping
    public ItemViewAllResponse viewAll(@RequestBody(required = false) @Valid ItemViewAllRequest param){
        return itemService.viewAll(param);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemRegistResponse regist(@RequestBody @Valid ItemRegistRequest param){
        return itemService.regist(param);
    }
}
