package com.choimory.itemvaluechecker.api.itemapi.item.entity;

import com.choimory.itemvaluechecker.api.itemapi.common.entity.CommonDateTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class ItemHtml extends CommonDateTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "item_id")
    private Item item;
    private String itemUrl;
    private String priceHtmlTag;

    @Builder(toBuilder = true)
    public ItemHtml(LocalDateTime createdAt, LocalDateTime modifiedAt, LocalDateTime deletedAt, Long id, Item item, String itemUrl, String priceHtmlTag) {
        super(createdAt, modifiedAt, deletedAt);
        this.id = id;
        this.item = item;
        this.itemUrl = itemUrl;
        this.priceHtmlTag = priceHtmlTag;
    }
}
