package br.com.controle_financeiro.controle_financeiro.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.controle_financeiro.controle_financeiro.Dtos.CostDto;
import br.com.controle_financeiro.controle_financeiro.Services.CostServiceIMPL;

@RestController
@RequestMapping("/despesas")
public class CostController {
    

    @Autowired
    CostServiceIMPL serviceCost;


    @PostMapping("/save")
    public ResponseEntity<CostDto> saveNewCost(@RequestBody @Valid CostDto costDto){
        return ResponseEntity.ok().body(serviceCost.saveCost(costDto));
    }
}
