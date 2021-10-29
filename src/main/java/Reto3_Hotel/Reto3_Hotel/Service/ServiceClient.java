/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3_Hotel.Reto3_Hotel.Service;

import Reto3_Hotel.Reto3_Hotel.Entity.Client;
import Reto3_Hotel.Reto3_Hotel.Repository.RepositoryClient;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ivonne
 */
@Service
public class ServiceClient {
    @Autowired
    private RepositoryClient metodosCrud;

    public List<Client> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Client> getClient(int ClientId) {
        return metodosCrud.getClient(ClientId);
    }

    public Client save(Client client) {
        if (client.getIdClient() == null) {
            return metodosCrud.save(client);
        } else {
            Optional<Client> evt2 = metodosCrud.getClient(client.getIdClient());
            if (evt2.isEmpty()) {
                return metodosCrud.save(client);
            } else {
                return client;
            }
        }
    }
    
    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> evt2= metodosCrud.getClient(client.getIdClient());
            if(!evt2.isEmpty()){
                if(client.getName()!=null){
                    evt2.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    evt2.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    evt2.get().setPassword(client.getPassword());
                }
                metodosCrud.save(evt2.get());
                return evt2.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            metodosCrud.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
