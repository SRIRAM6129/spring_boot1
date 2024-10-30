package com.prod.one;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceLayer {

    @Autowired
    private ClientRepo clientrep;

    @Autowired
    private ProductRepo productrep;
    @Autowired
    private ProductRepo productRepo;

    public List<ClientModel> showall() {
        return clientrep.findAll();
    }

    public ClientModel showClient(int id) {
        return clientrep.findById(id).orElse(new ClientModel());
    }

    public void addClient(ClientModel client) {
        clientrep.save(client);
    }

    public void deleteClient(int id) {
        clientrep.deleteById(id);
    }

    public void addProd(int id , double quantity) {
        ClientModel client = clientrep.findById(id).orElse(null);
        if(client != null) {
            ProductModel prod = new ProductModel();
            prod.setClient(client);
            prod.setQuantity(quantity);
            productrep.save(prod);
        }
        else {
            throw new IllegalArgumentException("ERROR IN ADD PRODUCT METHOD WHILE"+id +"ENTERING");
        }

    }
    public List<ProductModel> showprod(int id) {
        return null;
    }

    public List<ProductModel> showdateprod(LocalDate start,LocalDate end){
        return null;
    }

    public List<ProductModel> showallprod() {
        return productrep.findAll();
    }

    public List<ProductModel> showDateProducts(LocalDate start) {
        return productrep.findByCreatedDateOrderByCustomerId(start);
    }
}
