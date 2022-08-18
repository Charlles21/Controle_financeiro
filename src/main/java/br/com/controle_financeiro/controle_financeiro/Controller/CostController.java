package br.com.controle_financeiro.controle_financeiro.Controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping
    public ResponseEntity<List<CostDto>> listAllCosts(){

        if(!serviceCost.listAllCosts().isEmpty()){
            return ResponseEntity.ok().body(serviceCost.listAllCosts());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(serviceCost.listAllCosts());
    }
}
