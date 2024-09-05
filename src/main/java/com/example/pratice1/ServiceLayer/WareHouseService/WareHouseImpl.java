package com.example.pratice1.ServiceLayer.WareHouseService;

import com.example.pratice1.Entity.WareHouse;
import com.example.pratice1.Repository.WareHouseRepo;

import java.util.List;
import java.util.Optional;

public interface WareHouseImpl {

    public WareHouse saveWareHouse(WareHouse wareHouse);

    public List<WareHouse> sendWareHouse();

    Optional<WareHouse> sendWareHouseById(long id);

    public boolean deleteWareHouseById(long id);

    public WareHouse updateWareHouseById(long id,WareHouse newWareHouse);

}
