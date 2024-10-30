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

    public List<ClientModel> showAllClientModel(){
        return clientrep.findAll();
    }

    public ClientModel showClientModel(int id){
        return clientrep.findById(id).orElse(null);
    }

    public void addClientModel(ClientModel clientModel){
        clientrep.save(clientModel);
    }

    public void deleteClientModel(int id){
        clientrep.deleteById(id);
    }


    public List<ProductModel> showAllProductModel(){
        return productrep.findAll();
    }
    public List<ProductModel> showProductModelByCustomerId(int clientid){
        return productrep.findByCustomerId(clientid);
    }
    public List<ProductModel> showProductModelByProductId(int productid){

    }
}
