package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Vet;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
public class VetServiceTest {

    @Autowired
    private VetService vetService;

    @Test
    public void testFindVetById() {
        String LAST_NAME_EXPECTED = "Smith";
        Integer ID = 1;
        Vet vet = null;
        try {
            vet = this.vetService.findById(ID);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testCreateVet() {
        String FIRST_NAME = "John";
        String LAST_NAME = "Doe";
        Vet vet = new Vet(FIRST_NAME, LAST_NAME);
        Vet vetCreated = this.vetService.create(vet);
        log.info("VET CREATED: " + vetCreated.toString());
        assertNotNull(vetCreated.getId());
    }

    @Test
    public void testUpdateVet() {
        String FIRST_NAME = "Jane";
        String LAST_NAME = "Doe";
        String UP_FIRST_NAME = "Janet";
        String UP_LAST_NAME = "Smith";
        Vet vet = new Vet(FIRST_NAME, LAST_NAME);
        log.info(">" + vet);
        Vet vetCreated = this.vetService.create(vet);
        log.info(">>" + vetCreated);
        Vet updatedVet = this.vetService.update(vetCreated);
        log.info(">>>>" + updatedVet);
    }

    @Test
    public void testDeleteVet() {
        String FIRST_NAME = "Steve";
        String LAST_NAME = "Johnson";
        Vet vet = new Vet(FIRST_NAME, LAST_NAME);
        vet = this.vetService.create(vet);
        log.info("Vet created: " + vet);
        try {
            this.vetService.delete(vet.getId());
        } catch (Exception e) {
            fail(e.getMessage());
        }
        Vet deletedVet = this.vetService.findById(vet.getId());
        assertNull(deletedVet, "Vet should be null after deletion");
    }
}
