package br.com.controle_financeiro.controle_financeiro.Services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    
}
