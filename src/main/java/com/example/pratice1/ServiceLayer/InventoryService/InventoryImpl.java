package com.example.pratice1.ServiceLayer.InventoryService;

import com.example.pratice1.Entity.Inventory;
import com.example.pratice1.Entity.Product;

import java.util.List;
import java.util.Optional;

public interface InventoryImpl {

    Inventory saveInventory(Inventory inventory, long productId,long wareHouseId);

    List<Inventory> sendInventory();

    Optional<Inventory> findInventoryById(long inventoryId);

    Inventory updateInventory(long id,Inventory inventory);

    Inventory updateProductWareHouseInventory(long inventoryId,long productId,long wareHouseId);

    Boolean deleteInventory(long inventoryId);
}
