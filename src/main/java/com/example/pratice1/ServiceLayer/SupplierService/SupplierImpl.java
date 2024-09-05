package com.example.pratice1.ServiceLayer.SupplierService;

import com.example.pratice1.Entity.Orders;
import com.example.pratice1.Entity.Supplier;

import java.util.List;

public interface SupplierImpl {
    Supplier saveSupplier(Supplier supplier);

    List<Supplier> sendAllSupplier();

    Supplier findSupplierById(long supplierId);

    Supplier addPrdouctSupplier(List<Integer> productId,long supplierId);

    Supplier updateSupplier(long supplierId,Supplier supplier);

    Boolean deleteSupplier(long supplierId);
}
