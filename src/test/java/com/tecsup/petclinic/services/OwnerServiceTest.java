package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.entities.Pet;
import com.tecsup.petclinic.services.OwnerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
public class OwnerServiceTest {

	@Autowired
   	private OwnerService ownerService;


	@Test
	public void testFindOwnerById() {
		String LAST_NAME_EXPECTED = "Rodriquez";
		Integer ID = 3;
		Owner owner = null;
		try {
			owner = this.ownerService.findById(ID);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		assertEquals(LAST_NAME_EXPECTED, owner.getLastName());
	}
	@Test
	public void testCreateOwner() {
		String FIRST_NAME = "Ellen";
		String LAST_NAME = "Joe";
		String ADDRESS = "cascanuaees";
		String CITY = "sta anita";
		String TELEPHONE = "6085663023";
		Owner owner = new Owner(FIRST_NAME, LAST_NAME, ADDRESS, CITY, TELEPHONE);
		Owner ownerCreated = this.ownerService.create(owner);
		log.info("OWNER CREATED: " + ownerCreated.toString());
		assertNotNull(ownerCreated.getId());
		assertEquals(FIRST_NAME, ownerCreated.getFirstName());
		assertEquals(LAST_NAME, ownerCreated.getLastName());
		assertEquals(ADDRESS, ownerCreated.getAddress());
		assertEquals(CITY, ownerCreated.getCity());
		assertEquals(TELEPHONE, ownerCreated.getTelephone());
	}
	@Test
    public void testUpdateOwner() {
		String FIRST_NAME = "Ellen";
		String LAST_NAME = "Joe";
		String ADDRESS = "cascanuaees";
		String CITY = "sta anita";
		String TELEPHONE = "6085663023";
		String UP_FIRST_NAME = "Janet";
		String UP_LAST_NAME = "Doe";
		String UP_ADDRESS = "puruchuco";
		String UP_CITY = "ate";
		String UP_TELEPHONE = "6066553023";
		Owner owner = new Owner(FIRST_NAME, LAST_NAME, ADDRESS, CITY, TELEPHONE);
		log.info(">" + owner);
		Owner ownerCreated = this.ownerService.create(owner);
		log.info(">>" + ownerCreated);
		ownerCreated.setFirstName(UP_FIRST_NAME);
		ownerCreated.setLastName(UP_LAST_NAME);
		ownerCreated.setAddress(UP_ADDRESS);
		ownerCreated.setCity(UP_CITY);
		ownerCreated.setTelephone(UP_TELEPHONE);
		Owner updatedOwner = this.ownerService.update(ownerCreated);
		log.info(">>>>" + updatedOwner);
		assertEquals(UP_FIRST_NAME, updatedOwner.getFirstName());
		assertEquals(UP_LAST_NAME, updatedOwner.getLastName());
		assertEquals(UP_ADDRESS, updatedOwner.getAddress());
		assertEquals(UP_CITY, updatedOwner.getCity());
		assertEquals(UP_TELEPHONE, updatedOwner.getTelephone());
	}
	@Test
    public void testDeleteOwner() {
		String FIRST_NAME = "Steve";
		String LAST_NAME = "John";
		String ADDRESS = "659 Cardinal Ave";
		String CITY = "Sun Prairie";
		String TELEPHONE = "756555174";
		Owner owner = new Owner(FIRST_NAME, LAST_NAME, ADDRESS, CITY, TELEPHONE);
		owner = this.ownerService.create(owner);
		log.info("Owner created: " + owner);
		try {
			this.ownerService.delete(owner.getId());
		} catch (Exception e) {
			fail(e.getMessage());
		}
		try {
			this.ownerService.findById(owner.getId());
			assertTrue(false);
		} catch (Exception e) {
			assertTrue(true);
		}
	}


}
