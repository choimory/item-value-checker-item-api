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
public class ItemImage extends CommonDateTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
    private String name;
    private String url;
    private String size;
    private String resizeName;
    private String resizeUrl;
    private String resizeSize;

    @Builder(toBuilder = true)
    public ItemImage(LocalDateTime createdAt, LocalDateTime modifiedAt, LocalDateTime deletedAt, Long id, Item item, String name, String url, String size, String resizeName, String resizeUrl, String resizeSize) {
        super(createdAt, modifiedAt, deletedAt);
        this.id = id;
        this.item = item;
        this.name = name;
        this.url = url;
        this.size = size;
        this.resizeName = resizeName;
        this.resizeUrl = resizeUrl;
        this.resizeSize = resizeSize;
    }
}
