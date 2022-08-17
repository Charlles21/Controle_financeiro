package br.com.controle_financeiro.controle_financeiro.Controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.controle_financeiro.controle_financeiro.Dtos.RevenueDetalDto;
import br.com.controle_financeiro.controle_financeiro.Dtos.RevenueDto;
import br.com.controle_financeiro.controle_financeiro.Services.RevenueServiceIMPL;

@RestController
@RequestMapping("/receitas")
public class RevenueController {
    
    @Autowired
    private RevenueServiceIMPL serviceRevenue;

    @PostMapping("/save")
    public ResponseEntity<RevenueDto> saveRevenue(@RequestBody @Valid RevenueDto revenueDto){
        
        return ResponseEntity.ok().body(serviceRevenue.saveRevenue(revenueDto));
    }

    @GetMapping
    public ResponseEntity<List<RevenueDto>> listAllRevenues(){
        
        return ResponseEntity.ok().body(serviceRevenue.listAllRevenue());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<RevenueDto>> findRevenueDto(@PathVariable Long id){

        if(serviceRevenue.findRevenueById(id) == null){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(serviceRevenue.findRevenueById(id));
        }else{
            return ResponseEntity.ok().body(serviceRevenue.findRevenueById(id));
        }
    }  

    @PutMapping("/{id}")    
    public ResponseEntity<RevenueDetalDto> upDateRevenue(@PathVariable Long id, @RequestBody RevenueDetalDto revenueDto){

        if(serviceRevenue.upDateById(id, revenueDto) == null){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(serviceRevenue.upDateById(id, revenueDto));

        }else{
            return ResponseEntity.ok().body(serviceRevenue.upDateById(id, revenueDto));
        }
    }

    @DeleteMapping("/{id}")
    public void  deletRevenueById(@PathVariable Long id){
        serviceRevenue.deletRevenue(id);      
    }
}
