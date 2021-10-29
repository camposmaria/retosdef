
package Reto3_Hotel.Reto3_Hotel.Repository;

import Reto3_Hotel.Reto3_Hotel.Entity.Room;
import Reto3_Hotel.Reto3_Hotel.Interface.InterfaceRoom;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ivonne
 */
@Repository
public class RepositoryRoom {
    @Autowired
    private InterfaceRoom crud1;
    
    public List<Room> getAll(){
      return (List<Room>)crud1.findAll();  
        }
    
    public Optional <Room> getRoom (int id){
        return crud1.findById(id);
        }
    public Room save (Room room){
        return crud1.save(room);
        }
    public void delete(Room room){
        crud1.delete(room);
    }
}