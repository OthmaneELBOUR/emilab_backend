package devjam.emilab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import devjam.emilab.model.Patient;

public interface PatientRepo extends JpaRepository<Patient, Long>{

}
