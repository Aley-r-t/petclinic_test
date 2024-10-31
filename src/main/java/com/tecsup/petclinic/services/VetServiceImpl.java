package com.tecsup.petclinic.services;

import java.util.List;
import java.util.Optional;

import com.tecsup.petclinic.exception.VetNotFoundException;
import com.tecsup.petclinic.repositories.VetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.tecsup.petclinic.entities.Vet;


@Service
@Slf4j
public class VetServiceImpl implements VetService {
    private final VetRepository vetRepository;

    public VetServiceImpl(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Vet create(Vet vet) {
        return vetRepository.save(vet);
    }

    @Override
    public Vet update(Vet vet) {
        return vetRepository.save(vet);
    }

    @Override
    public Vet delete(Integer id) {
        Vet vet = findById(id);
        if (vet != null) {
            vetRepository.delete(vet);
        }
        return vet;
    }

    @Override
    public Vet findById(Integer id) {
        Optional<Vet> vet = vetRepository.findById(id);
        if (!vet.isPresent()) {
            System.out.println("Vet not found with id " + id);
        }
        return vet.orElse(null);
    }
}
