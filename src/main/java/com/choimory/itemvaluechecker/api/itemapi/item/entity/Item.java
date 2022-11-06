package com.choimory.itemvaluechecker.api.itemapi.item.entity;

import com.choimory.itemvaluechecker.api.itemapi.common.entity.CommonDateTimeEntity;
import com.choimory.itemvaluechecker.api.itemapi.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Item extends CommonDateTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String thumbnail;
    private Integer priceGoal;
    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;
    @OneToOne(mappedBy = "item")
    private ItemHtml itemHtml;
    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
    private List<ItemImage> itemImages = new ArrayList<>();
    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
    private List<ItemPriceHistory> itemPriceHistories = new ArrayList<>();

    @Builder(toBuilder = true)
    public Item(LocalDateTime createdAt, LocalDateTime modifiedAt, LocalDateTime deletedAt, Long id, String title, String content, String thumbnail, Integer priceGoal, Member member, ItemHtml itemHtml, Category category, List<ItemImage> itemImages, List<ItemPriceHistory> itemPriceHistories) {
        super(createdAt, modifiedAt, deletedAt);
        this.id = id;
        this.title = title;
        this.content = content;
        this.thumbnail = thumbnail;
        this.priceGoal = priceGoal;
        this.member = member;
        this.itemHtml = itemHtml;
        this.category = category;
        this.itemImages = itemImages;
        this.itemPriceHistories = itemPriceHistories;
    }
}
