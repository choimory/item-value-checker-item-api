package com.choimory.itemvaluechecker.api.itemapi.item.controller;

import com.choimory.itemvaluechecker.api.itemapi.item.data.request.RequestItemRegister;
import com.choimory.itemvaluechecker.api.itemapi.item.data.request.RequestItemFindAll;
import com.choimory.itemvaluechecker.api.itemapi.item.data.response.ResponseItemRegister;
import com.choimory.itemvaluechecker.api.itemapi.item.data.response.ResponseItemFindAll;
import com.choimory.itemvaluechecker.api.itemapi.item.data.response.ResponseItemFind;
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
    public ResponseItemFind find(@PathVariable
                                     @Valid
                                     @Min(value = 1)
                                     @Digits(integer = Integer.MAX_VALUE /*2147483647*/, fraction = 0) final Long id){
        return itemService.find(id);
    }

    @PostMapping
    public ResponseItemFindAll findAll(@RequestBody(required = false) @Valid RequestItemFindAll param){
        return itemService.findAll(param);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseItemRegister register(@RequestBody @Valid RequestItemRegister param){
        return itemService.register(param);
    }
}
