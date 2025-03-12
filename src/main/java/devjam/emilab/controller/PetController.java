package devjam.emilab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devjam.emilab.model.Pet;
import devjam.emilab.service.PetService;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping("/{id}")
    public Pet getPetById(@PathVariable("id") Long id) {
        return petService.getPetById(id);
    }

    @PostMapping("/new")
    public Pet createNewPet(@RequestBody Pet pet) {
        return petService.createNewPet(pet);
    }

    @PostMapping("/assign/{petId}/{personId}")
    public Pet assignToPerson(@PathVariable Long petId, @PathVariable Long personId) {
        return petService.assignToPatient(petId, personId);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePet(@PathVariable Long id) {
        petService.deletePet(id);
    }

    @PutMapping("/update/{id}")
    public Pet updatePet(@PathVariable Long id, @RequestBody Pet pet) {
        return petService.updatePet(pet);
    }

    @PutMapping("/feed/{id}/{happiness}/{hunger}")
    public Pet feed(@PathVariable Long id, @PathVariable int happiness, @PathVariable int hunger) {
        return petService.feed(id, happiness, hunger);
    }

    @PutMapping("/play/{id}/{happiness}/{energy}/{hunger}")
    public Pet play(@PathVariable Long id, @PathVariable int happiness, @PathVariable int energy, @PathVariable int hunger) {
        return petService.play(id, happiness, energy, hunger);
    }

    @PutMapping("/rest/{id}/{energy}")
    public Pet rest(@PathVariable Long id, @PathVariable int energy) {
        return petService.rest(id, energy);
    }


    
}
