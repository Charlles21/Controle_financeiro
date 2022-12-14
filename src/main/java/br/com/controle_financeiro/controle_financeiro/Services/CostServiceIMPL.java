package br.com.controle_financeiro.controle_financeiro.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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


    @Override
    public List<CostDto> listAllCosts() {
        List<Costs> listOfCosts = repositoryCost.findAll();
        return listOfCosts.stream().map(costs -> mapper.map(costs, CostDto.class)).collect(Collectors.toList());
    }


    @Override
    public Optional<CostDto> findCostById(Long id) {
       Optional<Costs> cost = repositoryCost.findById(id);

       if(cost.isPresent()){
        CostDto  costDto = mapper.map(cost.get(), CostDto.class);

        return Optional.of(costDto);
       }

        return null;
    }


    @Override
    public CostDto upDateCostById(Long id, CostDto costDto) {
        Optional<Costs> cost = repositoryCost.findById(id);

        if(cost.isPresent()){           
            Costs costUpdated = mapper.map(costDto, Costs.class);
            costUpdated.setId(id);
            repositoryCost.save(costUpdated);
            return mapper.map(costUpdated, CostDto.class);
           }
    
            return null;
      
    }


    @Override
    public void deleteCostById(Long id) {
        repositoryCost.deleteById(id);
    }


    
}
