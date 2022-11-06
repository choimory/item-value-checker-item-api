package com.choimory.itemvaluechecker.api.itemapi.item.entity;

import com.choimory.itemvaluechecker.api.itemapi.common.entity.CommonDateTimeEntity;
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
public class Category extends CommonDateTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int depth;
    private String name;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
    private List<Category> children = new ArrayList<>();

    @Builder(toBuilder = true)
    public Category(LocalDateTime createdAt, LocalDateTime modifiedAt, LocalDateTime deletedAt, Long id, int depth, String name, Category parent, List<Category> children) {
        super(createdAt, modifiedAt, deletedAt);
        this.id = id;
        this.depth = depth;
        this.name = name;
        this.parent = parent;
        this.children = children;
    }
}
