package pfe.example.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pfe.example.Entities.Pricing;

@Repository
public interface PricingRep extends JpaRepository <Pricing,Integer>{

}