package com.example.pratice1.ServiceLayer.SupplierService;

import com.example.pratice1.Entity.Orders;
import com.example.pratice1.Entity.Product;
import com.example.pratice1.Entity.Supplier;
import com.example.pratice1.Repository.ProductRepo;
import com.example.pratice1.Repository.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService implements SupplierImpl{

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private SupplierRepo supplierRepo;
    @Override
    public Supplier saveSupplier(Supplier supplier) {
        return supplierRepo.save(supplier);
    }

    @Override
    public List<Supplier> sendAllSupplier() {
        return supplierRepo.findAll();
    }

    @Override
    public Supplier findSupplierById(long supplierId) {
        Supplier supplier=supplierRepo.findById(supplierId).orElseThrow(null);

        return supplier;
    }

    @Override
    public Supplier addPrdouctSupplier(List<Integer> productId,long supplierId) {
        Supplier supplier=supplierRepo.findById(supplierId).orElseThrow(null);
        for (long i:productId
             ) {
            Product product=productRepo.findById(i).orElseThrow(null);
            supplier.getProduct().add(product);
        }
        return supplierRepo.save(supplier);
    }


    @Override
    public Supplier updateSupplier(long supplierId, Supplier supplier) {
        Supplier oldSupplier=supplierRepo.findById(supplierId).orElseThrow(null);
        oldSupplier.setSupplierName(supplier.getSupplierName());
        oldSupplier.setSupplierContactNo(supplier.getSupplierContactNo());
        return supplierRepo.save(oldSupplier);
    }

    @Override
    public Boolean deleteSupplier(long supplierId) {
        Supplier supplier=supplierRepo.findById(supplierId).orElseThrow(null);
        supplierRepo.deleteById(supplier.getSupplierId());
        if(supplierRepo.existsById(supplierId))
            return false;
        return true;
    }
}
