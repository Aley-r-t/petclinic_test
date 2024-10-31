package com.tecsup.petclinic.entities;


import jakarta.persistence.*;
import lombok.Data;


@Entity(name="vets")
@Data
public class Vet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String first_name;
    private String last_name;

    public Vet(){
    }

    public Vet(Integer id, String first_name, String last_name){
        super();
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Vet(String first_name, String last_name){
        super();
        this.first_name = first_name;
        this.last_name = last_name;
    }


}
