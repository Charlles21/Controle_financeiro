package br.com.controle_financeiro.controle_financeiro.Services;

import java.util.List;
import java.util.Optional;

import br.com.controle_financeiro.controle_financeiro.Dtos.CostDto;

public interface CostService {
    CostDto saveCost(CostDto costDto);
    List<CostDto> listAllCosts();
    Optional<CostDto> findCostById(Long id);
    CostDto upDateCostById(Long id, CostDto costDto);
}
