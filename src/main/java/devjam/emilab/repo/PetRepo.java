package devjam.emilab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import devjam.emilab.model.Pet;

public interface PetRepo extends JpaRepository<Pet, Long> {

    Pet findByName(String name);

}
