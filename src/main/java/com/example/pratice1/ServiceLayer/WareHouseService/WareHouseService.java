package com.example.pratice1.ServiceLayer.WareHouseService;

import com.example.pratice1.Entity.WareHouse;
import com.example.pratice1.Repository.WareHouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WareHouseService implements WareHouseImpl{

    @Autowired
    private WareHouseRepo wareHouseRepo;
    @Override
    public WareHouse saveWareHouse(WareHouse wareHouse) {
        return wareHouseRepo.save(wareHouse);
    }

    @Override
    public List<WareHouse> sendWareHouse() {
        return wareHouseRepo.findAll();
    }

    @Override
    public Optional<WareHouse> sendWareHouseById(long id) {
        return wareHouseRepo.findById(id);
    }

    @Override
    public boolean deleteWareHouseById(long id) {
        WareHouse wareHouse=wareHouseRepo.findById(id).orElseThrow(null);
        wareHouseRepo.deleteById(id);
        if(wareHouseRepo.existsById(id))
            return false;
        return true;
    }

    @Override
    public WareHouse updateWareHouseById(long id, WareHouse newWareHouse) {
       WareHouse wareHouse=wareHouseRepo.findById(id).orElseThrow(null);
       wareHouse.setWarehouseName(newWareHouse.getWarehouseName());
       wareHouse.setWarehouseLocation(newWareHouse.getWarehouseLocation());
       wareHouseRepo.save(wareHouse);
       return wareHouse;
    }
}
