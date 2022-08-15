package com.choimory.itemvaluechecker.api.itemapi.item.entity;

import com.choimory.itemvaluechecker.api.itemapi.common.entity.CommonDateTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemPriceHistory extends CommonDateTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
    private Integer price;
}
