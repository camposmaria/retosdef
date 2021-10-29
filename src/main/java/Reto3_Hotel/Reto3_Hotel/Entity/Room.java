
package Reto3_Hotel.Reto3_Hotel.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase entidad que nos permite crear las tablas con los paramentros de esta clase
 * Denomimanos la tabla con el nombre correspondiente en nuestra base de datos.
 * se establece la llave pirmaria y se trabaja como autoincremental
 * Se agregan todos los parametros como variables con el tipo de dato correspondiente 
 * @author Ivonne
 */
@Entity
@Table (name="room")
public class Room implements Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    /**
     * variable que vamos a emplear como llave primaria
     */          
    private Integer id;
    /**
     * atributo con el nombre de la habitacion.
     */
    private String name;
        /**
     * atributo con el hotel de la habitacion
     */
    private String hotel;
    /**
     * atributo con el numero de estrellas de la habitacion
     */
    private Integer stars;
    
    /**
     * atributo con la descripcion de la habitacion
     */
    private String description;   
    
    /**
     * se establecen las relaciones entre room y categoria, los elementos de room tienen
     * un elemento de categoria :muchos a uno
     * se establece la relacion entre room y y message  uno a muchos
     * se establlece la relacion entre room y reservation uno a muchos
     */
    
    @ManyToOne
    @JoinColumn(name ="categoryId")
    @JsonIgnoreProperties("rooms")
    private Category category;
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="room")
    @JsonIgnoreProperties({"room","client"})
    /**
     * lista con los mensajes de la habitacion
     */
    private List<Message>messages;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="room")
    @JsonIgnoreProperties({"rooms","client"})
    /**
     * lista con las reservaciones de la habitacion
     */
    private List<Reservation>reservations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    
    /**
     * Creacion de los metodos get y set para poder obtener una lista con los datos de 
     * la tabla y para obtener un objeto en particular  según su id y tambien 
     * para  guardar algun objeto con la relaciones establecidas
     * @return 
     */
    
}

