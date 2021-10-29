//1.Entidad
//2.Interface
//3.Repositorio
//4.servicios
//5.Controlador
//6Camie el nombre de la clase principal


package Reto3_Hotel.Reto3_Hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan(basePackages = {"Reto3_Hotel.Reto3_Hotel.Entity"})
public class Reto3HotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(Reto3HotelApplication.class, args);
	}

}
