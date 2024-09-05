package com.example.pratice1.ControllerLayer;

import com.example.pratice1.Entity.WareHouse;
import com.example.pratice1.ServiceLayer.WareHouseService.WareHouseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WareHouseController {
    @Autowired
    private WareHouseImpl wareHouseImpl;

    @PostMapping("/saveWareHouse")
    public ResponseEntity<WareHouse> saveWareHouseDetails(@RequestBody WareHouse wareHouse){
        return new ResponseEntity<WareHouse>(wareHouseImpl.saveWareHouse(wareHouse), HttpStatus.CREATED);
    }

    @GetMapping("/viewWareHouse")
    public ResponseEntity<List<WareHouse>> sendWareHouseDetails(){
        return new ResponseEntity<List<WareHouse>>(wareHouseImpl.sendWareHouse(),HttpStatus.OK);
    }

    @GetMapping("/findWareHouseById/{wareHouseId}")
    public ResponseEntity<Optional<WareHouse>> sendWareHouseDetailsById(@PathVariable long wareHouseId){
        return new ResponseEntity<Optional<WareHouse>>(wareHouseImpl.sendWareHouseById(wareHouseId),HttpStatus.FOUND);
    }
       

    @DeleteMapping("/deleteById/{id}")
    public boolean deleteWareHouseDetailsById(@PathVariable long id){
        return wareHouseImpl.deleteWareHouseById(id);
    }

    @PutMapping("/updateWareHouse/{id}")
    public ResponseEntity<WareHouse> updateWareHouseDetailsById(@PathVariable long id,@RequestBody WareHouse wareHouse){
        return new ResponseEntity<WareHouse>(wareHouseImpl.updateWareHouseById(id,wareHouse),HttpStatus.OK);
    }
}
