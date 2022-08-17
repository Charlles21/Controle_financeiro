package br.com.controle_financeiro.controle_financeiro.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controle_financeiro.controle_financeiro.Dtos.RevenueDetalDto;
import br.com.controle_financeiro.controle_financeiro.Dtos.RevenueDto;
import br.com.controle_financeiro.controle_financeiro.Models.Revenue;
import br.com.controle_financeiro.controle_financeiro.Repository.RevenueRepository;

@Service
public class RevenueServiceIMPL implements RevenueService{

    @Autowired
    RevenueRepository repositoryRevenue;

    ModelMapper mapper = new ModelMapper();

    @Override
    public RevenueDto saveRevenue(RevenueDto revenueDto) {
        
        Revenue revenue = mapper.map(revenueDto, Revenue.class);

        repositoryRevenue.save(revenue);
        revenueDto = mapper.map(revenue, RevenueDto.class);
        return revenueDto;
    }

    @Override
    public List<RevenueDto> listAllRevenue() {
        List<Revenue> revenueList = repositoryRevenue.findAll();
        
        return revenueList.stream().map(revenue -> mapper.map(revenue, RevenueDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<RevenueDto> findRevenueById(Long id) {
        Optional<Revenue>  revenue = repositoryRevenue.findById(id);

        if(revenue.isPresent()){

         RevenueDto revenueDto = new ModelMapper().map(revenue.get(), RevenueDto.class);

         return Optional.of(revenueDto);   
        }

        return null;
    }

    @Override
    public RevenueDetalDto upDateById(Long id,RevenueDetalDto revenueDto) {

        Optional<Revenue>  revenue = repositoryRevenue.findById(id);

        if(revenue.isPresent()){
            Revenue revenueUpDate = mapper.map(revenueDto, Revenue.class);
            revenueUpDate.setId(id);
            repositoryRevenue.save(revenueUpDate);
         return mapper.map(revenueUpDate, RevenueDetalDto.class);   
        }

        return null;
       
    }

    @Override
    public void deletRevenue(Long id) {
        repositoryRevenue.deleteById(id);       
    }

    
    
    
}
