package com.prod.one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
public class ControllerLayer {

    @Autowired
    ServiceLayer service;


    @GetMapping("/" )
    public String hello() {
        return "ITS WORKING";
    }
    @GetMapping("/showallclient")
    public List<ClientModel> showAllClient(){
        return service.showAllClientModel();
    }
    @GetMapping("/showclient/{id}")
    public ClientModel showClientModel(@PathVariable("id") int id) {
        return service.showClientModel(id);
    }
    @PostMapping("/addclient")
    public void addClientModel(@RequestBody ClientModel model) {
        service.addClientModel(model);
    }
    @DeleteMapping("/showclient/{id}/delete")
    public void deleteClientModel(@PathVariable("id") int id) {
        service.deleteClientModel(id);
    }


    @GetMapping("/showallproduct")
    public List<ProductModel> showAllProduct(){
        return service.showAllProductModel();
    }
    @GetMapping("/showclient/{id}/product")
    public List<ProductModel> showProductModelByCustomerId(@PathVariable("id") int id) {
        return service.showProductModelByCustomerId(id);
    }@PostMapping("/showclient/{id}/product")
    public ResponseEntity<String> addProductModel(@PathVariable("id") int id, @RequestBody ProductModel model) {

        return  ResponseEntity.ok("THE  PRODUCT HAS BEEN SUCCESSFULLY CREATED");
    }



}
