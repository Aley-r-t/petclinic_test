package com.tecsup.petclinic.services;

import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.repositories.OwnerRepository;

@Service
@Slf4j
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner create(Owner owner) {
        return ownerRepository.save(owner);
    }


    @Override
    public Owner update(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void delete(Integer id) {
        Owner owner = findById(id);
        ownerRepository.delete(owner);
    }


    @Override
    public Owner findById(Integer id) {
        Optional<Owner> owner = ownerRepository.findById(id);
        if (!owner.isPresent()) {
            System.out.println("Owner not found with id " + id);
        }
        return owner.get();
    }

}
