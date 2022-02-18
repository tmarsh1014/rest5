package com.example.rest5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NameController {

    @Autowired
    private NameDAO nameDAO = new NameDAO();

    //Retrieve all name objects
    @RequestMapping(value = "/names",method = RequestMethod.GET)
    public List<Name> getNames(){
        return nameDAO.getAll();
    }

    //Retrieve a single name object
    @RequestMapping(value = "names/{id}",method = RequestMethod.GET)
    public Name nameByID(@PathVariable int id){
        return nameDAO.getByID(id);
    }

    //Create a name object in the database
    @RequestMapping(value="names",method= RequestMethod.POST)
    public Name names(@RequestBody Name name){
        nameDAO.create(name);
        return name;
    }

    //Create a list of name objects in the database from an array of strings
    @RequestMapping(value="namesList",method= RequestMethod.POST)
    public List<Name> namesList(@RequestBody List<Name> names){
        for(Name name: names){
            nameDAO.create(name);
        }
        return names;
    }

    //Update a selected name
    @RequestMapping(value = "names",method = RequestMethod.PUT)
    public Name updateName(@RequestBody Name name){
        return nameDAO.updateByName(name);
    }

    //Delete a name
    @RequestMapping(value = "names/{id}",method = RequestMethod.DELETE)
    public String deleteName(@PathVariable int id){
        nameDAO.deleteByID(id);
        return "ID " + id + " deleted.";
    }
}
