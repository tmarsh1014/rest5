package com.example.rest5;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class NameDAO {
    @PersistenceContext
    private EntityManager entMan; //how to talk to hivernate

    //Insert into the database
    public Name create(Name name){
        entMan.persist(name); //save it in database
        entMan.flush(); //reload from database
        return name; //return
    }

    //Retrieve all of the Names
    public List<Name> getAll(){
        List<Name> names = entMan.createQuery("Select h from Name h", Name.class).getResultList();
        return names;
    }

    //Retrieve a single Name
    public Name getByID(int id){
        Name name = entMan.find(Name.class, id);
        if (name == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID" + id + " was not found");
        }
        return name;
    }

    //Update Name
    public Name updateByName(Name name){
        entMan.merge(name);
        entMan.flush();
        return name;
    }

    //Delete Name
    public void deleteByID(int id){
        Name name = getByID(id);
        if (name == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID" + id + " was not found");
        }
        entMan.remove(name);
    }

}
