package com.example.pratice1.ControllerLayer;

import com.example.pratice1.Entity.Product;
import com.example.pratice1.Entity.Supplier;
import com.example.pratice1.ServiceLayer.SupplierService.SupplierImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierImpl supplierImpl;

    @PostMapping("/saveSupplier")
    public ResponseEntity<Supplier> saveSupplierDetails(@RequestBody Supplier supplier){
        return new ResponseEntity<Supplier>(supplierImpl.saveSupplier(supplier), HttpStatus.CREATED);
    }

    @GetMapping("/sendSupplier")
    public ResponseEntity<List<Supplier>> sendAllSupplierDetails(){
        return new ResponseEntity<List<Supplier>>(supplierImpl.sendAllSupplier(),HttpStatus.OK);
    }

    @GetMapping("/{supplierId}")
    public ResponseEntity<Supplier> sendSupplierById(@PathVariable long supplierId){
        return new ResponseEntity<Supplier>(supplierImpl.findSupplierById(supplierId),HttpStatus.FOUND);
    }
    @PutMapping("/{supplierId}")
    public ResponseEntity<Supplier> updateSupplierDetails(@PathVariable long supplierId,@RequestBody Supplier supplier){
        return new ResponseEntity<Supplier>(supplierImpl.updateSupplier(supplierId,supplier),HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{supplierId}")
    public ResponseEntity<Boolean> deleteSupplierById(@PathVariable long supplierId){
        return new ResponseEntity<Boolean>(supplierImpl.deleteSupplier(supplierId),HttpStatus.OK);
    }

    @PostMapping("/{supplierId}")
    public ResponseEntity<Supplier> addProductDetailsToSupplier(@RequestBody List<Integer> productId,@PathVariable long supplierId){
        return new ResponseEntity<Supplier>(supplierImpl.addPrdouctSupplier(productId,supplierId),HttpStatus.CREATED);
    }
}
