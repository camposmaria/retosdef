
package Reto3_Hotel.Reto3_Hotel.Interface;

import Reto3_Hotel.Reto3_Hotel.Entity.Message;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Ivonne
 */
public interface InterfaceMessage extends CrudRepository<Message,Integer> {
    
}
