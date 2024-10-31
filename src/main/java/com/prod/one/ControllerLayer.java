package com.prod.one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
@RestController
@CrossOrigin
public class ControllerLayer {

    @Autowired
    ServiceLayer service;
    @Autowired
    private ExcelGenerator excelGenerator;


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
    @GetMapping("/client/{id}/product")
    public List<ProductModel> showProductModelByCustomerId(@PathVariable("id") int id) {
        return service.showProductModelByCustomerId(id);
    }

    //SHOW PRODUCT OF AN CLIENT BETWEEN THE DATE
    @GetMapping("/client/{id}/product/date")
    public List<ProductModel> showProductModelByDate(@PathVariable("id") int id) {
        return null;
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

    //EXCEL FOR SHOW PRODUCT BASED ON CUSTOMER ID BETWEEN DATE
    @GetMapping("/client/{id}/product/date")
    public ResponseEntity<String> createExcelOnProductByCustomerIdBetweenDate(@PathVariable("id") int id){
        return ResponseEntity.ok("EXCEL BASED ON CUSTOMER ID BETWEEN DATE HAS BEEN SUCCESSFULLY GENERATED");
    }

    //EXCEL FOR SHOW PRODUCT BETWEEN THE DATE
    @GetMapping("/showproduct/date/excel")
    public ResponseEntity<String> createExcelOnProductByBetweenDate(
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
        return ResponseEntity.ok("EXCEL BETWEEN DATE HAS BEEN SUCCESSFULLY GENERATED");
    }

    //EXCEL FOR SHOW PRODUCT BASED ON CUSTOMER ID
    @GetMapping("/client/{id}/product/excel")
    public ResponseEntity<byte[]> createExcelOnProductByCustomerId(@PathVariable("id") int id) throws IOException {

        List <ProductModel> products = service.showProductModelByCustomerId(id);

        byte[] excelFile = excelGenerator.createExcelOnProductByCustomerId(products);

        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename= PRODUCTS.xls")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(excelFile);
    }

}

