package br.com.controle_financeiro.controle_financeiro.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.controle_financeiro.controle_financeiro.Models.Costs;

public interface CostRepository extends JpaRepository<Costs, Long>{
    
}
