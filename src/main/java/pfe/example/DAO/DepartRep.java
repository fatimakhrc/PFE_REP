package pfe.example.DAO;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pfe.example.Entities.Depart;

@Repository
public interface DepartRep extends JpaRepository<Depart,Long>{

}