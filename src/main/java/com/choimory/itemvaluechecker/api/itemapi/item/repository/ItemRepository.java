package com.choimory.itemvaluechecker.api.itemapi.item.repository;

import com.choimory.itemvaluechecker.api.itemapi.item.entity.Item;
import com.choimory.itemvaluechecker.api.itemapi.item.querydsl.QItemRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>, QItemRepository {

}
