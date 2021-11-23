package com.switchfully.order.domain.items;

import com.switchfully.order.domain.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;
import javax.inject.Named;

@org.springframework.stereotype.Repository
public class ItemRepository extends Repository<Item, ItemDatabase> {

    @Autowired
    public ItemRepository(ItemDatabase database) {
        super(database);
    }
}
