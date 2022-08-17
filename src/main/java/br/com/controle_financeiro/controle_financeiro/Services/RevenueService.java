package br.com.controle_financeiro.controle_financeiro.Services;

import java.util.List;
import java.util.Optional;

import br.com.controle_financeiro.controle_financeiro.Dtos.RevenueDetalDto;
import br.com.controle_financeiro.controle_financeiro.Dtos.RevenueDto;


public interface RevenueService {
    
    RevenueDto saveRevenue(RevenueDto revenueDto);
    List<RevenueDto> listAllRevenue();
    Optional<RevenueDto> findRevenueById(Long id); 
    RevenueDetalDto upDateById(Long id, RevenueDetalDto revenueDto);
    void deletRevenue(Long id); 
}
