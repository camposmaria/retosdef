
package Reto3_Hotel.Reto3_Hotel.Service;

import Reto3_Hotel.Reto3_Hotel.Entity.Category;
import Reto3_Hotel.Reto3_Hotel.Repository.RepositoryCategory;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ivonne
 */
@Service
public class ServiceCategory {

    @Autowired
    private RepositoryCategory metodosCrud;

    public List<Category> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Category> getCategory(int CategoryId) {
        return metodosCrud.getCategory(CategoryId);
    }

    public Category save(Category category) {
        if (category.getId() == null) {
            return metodosCrud.save(category);
        } else {
            Optional<Category> evt1 = metodosCrud.getCategory(category.getId());
            if (evt1.isEmpty()) {
                return metodosCrud.save(category);
            } else {
                return category;
            }
        }
    }
    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category> evt1 = metodosCrud.getCategory(category.getId());
            if(!evt1.isEmpty()){
                if(category.getDescription()!=null){
                    evt1.get().setDescription(category.getDescription());
                }
                if(category.getName()!=null){
                    evt1.get().setName(category.getName());
                }
                return metodosCrud.save(evt1.get());
            }
        }
        return category;
    }
    public boolean deletecategory(int categoryId){
        Boolean dato=getCategory(categoryId).map(category -> {
            metodosCrud.delete(category);
            return true;
        }).orElse(false);
        return dato;
    }
}
