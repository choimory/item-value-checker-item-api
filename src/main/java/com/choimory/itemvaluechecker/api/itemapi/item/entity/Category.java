package com.choimory.itemvaluechecker.api.itemapi.item.entity;

import com.choimory.itemvaluechecker.api.itemapi.common.entity.CommonDateTimeEntity;
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
}
