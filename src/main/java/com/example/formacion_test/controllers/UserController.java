package com.example.formacion_test.controllers;

import java.util.ArrayList;

import com.example.formacion_test.models.User;
import com.example.formacion_test.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Le decimos que va a ser una respuest de tipo REST
@RequestMapping("/usuario") //RUTA DONDE VAMOS A LLAMAR
public class UserController {
    @Autowired
    UserService userService;

        //QUE ESTAMOS CONSTRUYENDO EN GENERAL? TODO ESTO QUE ESTAMOS HACIENDO ??? QUE DEMONIOS ES POR EL BENDITO NOMBRE DE CUPIDO? 
        // ES UNA API 
        //GET POST DELETE PATCH UPDATE
        
    //GET
    @GetMapping()
    public ArrayList<User> obtenerUsuarios(){
        return userService.todoLosUsuarios();
    }

    @PostMapping()
    public String guardar(@RequestBody User user){
        return userService.guardar(user);
    }

    


    
}
