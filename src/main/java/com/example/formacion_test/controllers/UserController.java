package com.example.formacion_test.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.formacion_test.models.User;
import com.example.formacion_test.services.UserService;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // Le decimos que va a ser una respuest de tipo REST
@RequestMapping("/usuario") //RUTA DONDE VAMOS A LLAMAR Loclahost:8080/usuario/1
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public ArrayList<User> obtenerUsuarios(){
        return userService.todoLosUsuarios();
    }

    @PostMapping()
    public String guardar(@RequestBody User user){
        return userService.guardar(user);
    }

   @GetMapping("/{id}")
    public String buscarPorId(@PathVariable("id") Long id){
         Optional<User> usuario = userService.buscarPorId(id);
         System.out.println(usuario);
         if(usuario.isPresent()){
            User user = usuario.get();
            return "Usuario existente - " + user.getNombre();
         }else{
             return "no existe ningun usuario con ese id";
         }   
    }

    @PostMapping("search")
    public List<User> buscar(@RequestParam("query") String query){
         var usuario = userService.buscarPorPalabra(query);
         System.out.println(usuario);
        return usuario;   
    }

    


    
}
