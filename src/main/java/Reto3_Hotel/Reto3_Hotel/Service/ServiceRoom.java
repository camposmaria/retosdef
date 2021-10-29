
package Reto3_Hotel.Reto3_Hotel.Service;

import Reto3_Hotel.Reto3_Hotel.Entity.Room;
import Reto3_Hotel.Reto3_Hotel.Repository.RepositoryRoom;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

/**
 *
 * @author Ivonne
 */

@Service
public class ServiceRoom {

    @Autowired
    private RepositoryRoom metodosCrud;

    public List<Room> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Room> getRoom(int roomId) {
        return metodosCrud.getRoom(roomId);
    }

    public Room save(Room room) {
        if (room.getId() == null) {
            return metodosCrud.save(room);
        } else {
            Optional<Room> evt = metodosCrud.getRoom(room.getId());
            if (evt.isEmpty()) {
                return metodosCrud.save(room);
            } else {
                return room;
            }
        }
    }
    public Room update(Room room){
        if(room.getId()!=null){
            Optional<Room> evt =metodosCrud.getRoom(room.getId());
            if(!evt.isEmpty()){
                if(room.getName()!=null){
                    evt.get().setName(room.getName());
                }
                if(room.getHotel()!=null){
                    evt.get().setHotel(room.getHotel());
                }
                if(room.getStars()!=null){
                    evt.get().setStars(room.getStars());
                }
                if(room.getDescription()!=null){
                    evt.get().setDescription(room.getDescription());
                }
                if(room.getCategory()!=null){
                    evt.get().setCategory(room.getCategory());
                }
                metodosCrud.save(evt.get());
                return evt.get();
            }else{
                return room;
            }
        }else{
            return room;
        }
    }

    public boolean deleteRoom(int roomId) {
        Boolean aBoolean = getRoom(roomId).map(room -> {
            metodosCrud.delete(room);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
