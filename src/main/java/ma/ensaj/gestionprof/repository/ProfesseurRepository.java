package ma.ensaj.gestionprof.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.ensaj.gestionprof.entities.Professseur;
@Repository
public interface ProfesseurRepository extends JpaRepository<Professseur, Long> {

}
