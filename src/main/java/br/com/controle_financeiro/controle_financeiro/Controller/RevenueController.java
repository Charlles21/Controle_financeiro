package br.com.controle_financeiro.controle_financeiro.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.controle_financeiro.controle_financeiro.Dtos.RevenueDto;
import br.com.controle_financeiro.controle_financeiro.Services.RevenueServiceIMPL;

@RestController
@RequestMapping("/receitas")
public class RevenueController {
    
    @Autowired
    RevenueServiceIMPL serviceRevenue;

    @PostMapping("/save")
    public ResponseEntity<RevenueDto> saveRevenue(@RequestBody @Valid RevenueDto revenueDto){
        
        return ResponseEntity.ok().body(serviceRevenue.saveRevenue(revenueDto));
    }
}
