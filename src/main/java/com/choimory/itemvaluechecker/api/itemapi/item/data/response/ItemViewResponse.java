package com.choimory.itemvaluechecker.api.itemapi.item.data.response;

import com.choimory.itemvaluechecker.api.itemapi.item.controller.ItemController;
import com.choimory.itemvaluechecker.api.itemapi.item.data.dto.ItemDto;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

@Builder
@NoArgsConstructor
@Getter
public class ItemViewResponse extends RepresentationModel<ItemViewResponse> {
    @JsonUnwrapped
    private ItemDto item;

    public ItemViewResponse(ItemDto item) {
        this.item = item;
        add(WebMvcLinkBuilder.linkTo(ItemController.class)
                .slash(item.getId())
                .withSelfRel());
    }
}
