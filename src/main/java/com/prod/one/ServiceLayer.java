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
    public void updateClientModel(ClientModel clientModel){
        clientrep.save(clientModel);
    }


    public List<ProductModel> showAllProductModel(){
        return productrep.findAll();
    }
    public List<ProductModel> showProductModelByCustomerId(int clientid){
        return productrep.findByCustomerId(clientid);
    }

    public void addProductModel(int customerId,double quantity){
        ClientModel client = clientrep.findById(customerId).orElse(null);
        if(client == null ){
            throw new RuntimeException("client not found");
        }
        else {
            ProductModel product = new ProductModel();
            product.setClient( client);
            product.setCustomerId(client.getId());
            product.setQuantity(quantity);
            productrep.save(product);
        }
    }
    public List<ProductModel> showProductModelByDate(LocalDate startDate, LocalDate endDate){
        return productrep.findByCreatedDateBetweenOrderByCreatedDateDescCustomerIdAscCreatedTimeDescId(startDate, endDate);
    }
}
