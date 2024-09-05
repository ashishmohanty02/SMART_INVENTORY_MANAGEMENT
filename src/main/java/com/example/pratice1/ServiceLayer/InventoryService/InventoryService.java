package com.example.pratice1.ServiceLayer.InventoryService;

import com.example.pratice1.Entity.Category;
import com.example.pratice1.Entity.Inventory;
import com.example.pratice1.Entity.Product;
import com.example.pratice1.Entity.WareHouse;
import com.example.pratice1.Repository.InventoryRepo;
import com.example.pratice1.Repository.ProductRepo;
import com.example.pratice1.Repository.WareHouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Optional;

@Service
public class InventoryService implements InventoryImpl{

    @Autowired
    private InventoryRepo inventoryRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private WareHouseRepo wareHouseRepo;
    @Override
    public Inventory saveInventory(Inventory inventory, long productId, long wareHouseId) {

        if(productId>0){
            Product product=productRepo.findById(productId).orElseThrow(null);
            inventory.setProduct(product);
        }
        if(wareHouseId>0){
            WareHouse wareHouse=wareHouseRepo.findById(wareHouseId).orElseThrow(null);
            inventory.setWareHouse(wareHouse);
        }
        return inventoryRepo.save(inventory);
    }

    @Override
    public List<Inventory> sendInventory() {
        return inventoryRepo.findAll();
    }

    @Override
    public Optional<Inventory> findInventoryById(long inventoryId) {
        if(inventoryRepo.existsById(inventoryId)){
            return inventoryRepo.findById(inventoryId);
        }
        throw new RuntimeException("Inventory Not found");
    }

    @Override
    public Inventory updateInventory(long id, Inventory inventory) {


            Inventory inventory1=inventoryRepo.findById(id).orElseThrow(null);
            inventory1.setQuantity(inventory.getQuantity());

        return inventoryRepo.save(inventory1);
    }

    @Override
    public Inventory updateProductWareHouseInventory(long inventoryId, long productId, long wareHouseId) {
        if(inventoryId>0){
            Inventory inventory=inventoryRepo.findById(inventoryId).orElseThrow(null);
            if(productId>0){
                Product product=productRepo.findById(productId).orElseThrow(null);
                inventory.setProduct(product);
            }
            if(wareHouseId>0){
                WareHouse wareHouse=wareHouseRepo.findById(wareHouseId).orElseThrow(null);
                inventory.setWareHouse(wareHouse);
            }
            return inventoryRepo.save(inventory);
        }

        throw new RuntimeException("Not Found");


    }

    @Override
    public Boolean deleteInventory(long inventoryId) {
        if(inventoryRepo.existsById(inventoryId)){
            inventoryRepo.deleteById(inventoryId);

        }else
            throw new RuntimeException("Inventory Not Present");
        return true;

    }
}
