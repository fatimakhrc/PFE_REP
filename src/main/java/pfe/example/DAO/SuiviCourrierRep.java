/* package pfe.example.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pfe.example.Entities.Courrier;
import pfe.example.Entities.SuiviCourrier;

public interface SuiviCourrierRep extends JpaRepository<SuiviCourrier, Long> {
    SuiviCourrier findTopByCourrierOrderByDateSuiviDesc(Courrier courrier);
    List<SuiviCourrier> findByCourrierOrderByDateSuiviDesc(Courrier courrier);
}



 */