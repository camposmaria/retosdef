/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reto3_Hotel.Reto3_Hotel.Interface;

import Reto3_Hotel.Reto3_Hotel.Entity.Client;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Ivonne
 */
public interface InterfaceClient extends CrudRepository<Client,Integer> {
    
}
