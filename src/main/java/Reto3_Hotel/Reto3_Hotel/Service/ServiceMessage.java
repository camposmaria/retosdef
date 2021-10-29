/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3_Hotel.Reto3_Hotel.Service;

import Reto3_Hotel.Reto3_Hotel.Entity.Message;
import Reto3_Hotel.Reto3_Hotel.Repository.RepositoryMessage;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ivonne
*/
@Service
public class ServiceMessage {
    @Autowired
    private RepositoryMessage metodosCrud;

    public List<Message> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Message> getMessage(int MessageId) {
        return metodosCrud.getMessage(MessageId);
    }

    public Message save(Message message) {
        if (message.getIdMessage() == null) {
            return metodosCrud.save(message);
        } else {
            Optional<Message> evt3 = metodosCrud.getMessage(message.getIdMessage());
            if (evt3.isEmpty()) {
                return metodosCrud.save(message);
            } else {
                return message;
            }
        }
    }
    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> evt3= metodosCrud.getMessage(message.getIdMessage());
            if(!evt3.isEmpty()){
                if(message.getMessageText()!=null){
                    evt3.get().setMessageText(message.getMessageText());
                }
                metodosCrud.save(evt3.get());
                return evt3.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            metodosCrud.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
