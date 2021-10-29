/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3_Hotel.Reto3_Hotel.Repository;

import Reto3_Hotel.Reto3_Hotel.Entity.Client;
import Reto3_Hotel.Reto3_Hotel.Interface.InterfaceClient;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ivonne
 */
@Repository
public class RepositoryClient {
    @Autowired
    private InterfaceClient crud2;
    
    public List<Client> getAll(){
        return (List<Client>) crud2.findAll();
    }
    public Optional <Client> getClient(int id){
        return crud2.findById(id);
    }
    
    public Client save(Client client){
        return crud2.save(client);
    }
    public void delete(Client client){
        crud2.delete(client);
    }
}
