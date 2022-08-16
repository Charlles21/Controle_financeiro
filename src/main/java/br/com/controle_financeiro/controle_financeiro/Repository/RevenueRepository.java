package br.com.controle_financeiro.controle_financeiro.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controle_financeiro.controle_financeiro.Models.Revenue;

@Repository
public interface RevenueRepository extends JpaRepository<Revenue, Long>{
    
}
