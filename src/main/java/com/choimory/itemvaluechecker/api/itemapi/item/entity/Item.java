package com.choimory.itemvaluechecker.api.itemapi.item.entity;

import com.choimory.itemvaluechecker.api.itemapi.common.entity.CommonDateTimeEntity;
import com.choimory.itemvaluechecker.api.itemapi.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
}
