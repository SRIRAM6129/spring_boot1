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


    //TEST IF SERVER IS RUNNING
    @GetMapping("/" )
    public String hello() {
        return "ITS WORKING";
    }

    //SHOW ALL CLIENTS
    @GetMapping("/showallclient")
    public List<ClientModel> showAllClient(){
        return service.showAllClientModel();
    }

    //SHOW CLIENT OF THE GIVEN ID
    @GetMapping("/client/{id}")
    public ClientModel showClientModel(@PathVariable("id") int id) {
        return service.showClientModel(id);
    }

    //ADD NEW CLIENT
    @PostMapping("/addclient")
    public void addClientModel(@RequestBody ClientModel model) {
        service.addClientModel(model);
    }

    //DELETE AN CLIENT
    @DeleteMapping("/client/{id}/delete")
    public void deleteClientModel(@PathVariable("id") int id) {
        service.deleteClientModel(id);
    }

    //ADD NEW PRODUCT
    @PostMapping("/client/{id}/product")
    public ResponseEntity<String> addProductModel(@PathVariable("id") int id, @RequestParam double quantity) {
        service.addProductModel(id,quantity);
        return  ResponseEntity.ok("THE  PRODUCT HAS BEEN SUCCESSFULLY CREATED");
    }

    //SHOW ALL THE PRODUCTS
    @GetMapping("/showallproduct")
    public List<ProductModel> showAllProduct(){
        return service.showAllProductModel();
    }

    //SHOW PRODUCTS OF AN CLIENT
    @GetMapping("/showclient/{id}/product")
    public List<ProductModel> showProductModelByCustomerId(@PathVariable("id") int id) {
        return service.showProductModelByCustomerId(id);
    }

    //SHOW PRODUCTS BETWEEN THE DATE
    @GetMapping("/showproduct/date")
    public List<ProductModel> showProductByDate(
            @RequestParam int startday,
            @RequestParam int startmonth,
            @RequestParam int startyear,
            @RequestParam int endday,
            @RequestParam int endmonth,
            @RequestParam int endyear
    )
    {
        LocalDate startdate = LocalDate.of(startyear, startmonth, startday);
        LocalDate enddate = LocalDate.of(endyear, endmonth, endday);
        return service.showProductModelByDate(startdate, enddate);
    }

}
