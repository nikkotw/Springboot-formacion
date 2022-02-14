package com.example.formacion_test.services;

import com.example.formacion_test.models.User;
import com.example.formacion_test.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service // VA A SER DE TIPO SERVICE Hace referencia a servicio....OSEA VAMOS A USAR UN SERVICIO. 
public class UserService {
   @Autowired // Inyectabamos dependencias. 
   UserRepository UserRepo; // Repositorio Usuario.


   public ArrayList<User> todoLosUsuarios(){
       
        return (ArrayList<User>) UserRepo.findAll();
   }

   public String guardar(User user){
       UserRepo.save(user);
       return "guardado correctamente";
   }
    
   

}
