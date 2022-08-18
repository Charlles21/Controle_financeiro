package br.com.controle_financeiro.controle_financeiro.Services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controle_financeiro.controle_financeiro.Dtos.CostDto;
import br.com.controle_financeiro.controle_financeiro.Models.Costs;
import br.com.controle_financeiro.controle_financeiro.Repository.CostRepository;

@Service
public class CostServiceIMPL implements CostService{

    @Autowired
    CostRepository repositoryCost;

 
    ModelMapper mapper = new ModelMapper();


    @Override
    public CostDto saveCost(CostDto costDto) {
      Costs cost = mapper.map(costDto, Costs.class);
      repositoryCost.save(cost);     
        return costDto;
    }


    
}
