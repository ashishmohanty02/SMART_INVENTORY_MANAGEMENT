package com.example.pratice1.ControllerLayer;

import com.example.pratice1.Entity.Inventory;
import com.example.pratice1.ServiceLayer.InventoryService.InventoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class InventoryController {

    @Autowired
    private InventoryImpl inventoryImpl;

    @PostMapping("/saveInventory/{productId}/{wareHouseId}")
    public ResponseEntity<Inventory> saveStock(@RequestBody Inventory inventory, @PathVariable long productId,@PathVariable long wareHouseId){
        return new ResponseEntity<Inventory>(inventoryImpl.saveInventory(inventory,productId,wareHouseId), HttpStatus.CREATED);
    }

    @GetMapping("/viewInventory")
    public ResponseEntity<List<Inventory>> sendInventoryDetails(){
        return new ResponseEntity<List<Inventory>>(inventoryImpl.sendInventory(),HttpStatus.OK);
    }

    @GetMapping("/viewInventoryById/{id}")
    public ResponseEntity<Optional<Inventory>> sendInventoryDetailsById(@PathVariable long id){
        return new ResponseEntity<Optional<Inventory>>(inventoryImpl.findInventoryById(id),HttpStatus.FOUND);
    }

    @PutMapping("/updateInventoryById/{id}")
    public ResponseEntity<Inventory> updateInventoryDetails(@PathVariable long id,@RequestBody Inventory inventory){
        return new ResponseEntity<Inventory>(inventoryImpl.updateInventory(id,inventory),HttpStatus.OK);
    }

    @PutMapping("/updateInventoryProductWareHouse/{inventoryId}/{productId}/{wareHouseId}")
    public ResponseEntity<Inventory> updateProductWareHouseInventoryDetails(@PathVariable long inventoryId,@PathVariable long productId,@PathVariable long wareHouseId){
        return new ResponseEntity<Inventory>(inventoryImpl.updateProductWareHouseInventory(inventoryId,productId,wareHouseId),HttpStatus.OK);
    }

    @DeleteMapping("/deleteInventory/{inventoryId}")
   public ResponseEntity<Boolean> deleteInventoryDetailsById(@PathVariable long inventoryId){
        return new ResponseEntity<Boolean>(inventoryImpl.deleteInventory(inventoryId),HttpStatus.GONE);
   }
}
