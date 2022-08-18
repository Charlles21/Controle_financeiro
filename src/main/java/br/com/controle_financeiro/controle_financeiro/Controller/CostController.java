package br.com.controle_financeiro.controle_financeiro.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CostDto>> findCostByid(@PathVariable Long id ){
        
        if(serviceCost.findCostById(id) == null){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(serviceCost.findCostById(id));
        }else{
            return ResponseEntity.ok().body(serviceCost.findCostById(id));
           
        }
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<CostDto> upDateCostById(@RequestBody @Valid CostDto costDto, @PathVariable Long id){

        if(serviceCost.upDateCostById(id, costDto) == null){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(serviceCost.upDateCostById(id, costDto));
        }else{
            return ResponseEntity.ok().body(serviceCost.upDateCostById(id, costDto));
        }
    }

}
