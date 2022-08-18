package br.com.controle_financeiro.controle_financeiro.Services;

import br.com.controle_financeiro.controle_financeiro.Dtos.CostDto;

public interface CostService {
    CostDto saveCost(CostDto costDto);
}
