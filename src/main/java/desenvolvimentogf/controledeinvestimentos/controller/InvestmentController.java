package desenvolvimentogf.controledeinvestimentos.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desenvolvimentogf.controledeinvestimentos.dto.InvestmentDTO;
import desenvolvimentogf.controledeinvestimentos.services.InvestmentService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("investments")
public class InvestmentController {
    private final InvestmentService investmentService;

    public InvestmentController(InvestmentService investmentService) {
        this.investmentService = investmentService;
    }

    @PostMapping
    public ResponseEntity<String> addInvestment(@Valid @RequestBody InvestmentDTO investmentDTO) {
        investmentService.create(investmentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Investimento adicionado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<InvestmentDTO>> getInvestments() {
        List<InvestmentDTO> investments = investmentService.list();
        return ResponseEntity.ok(investments);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateInvestment(@PathVariable int id, @Valid @RequestBody InvestmentDTO investmentDTO) {
        investmentService.update(id, investmentDTO);
        return ResponseEntity.ok("Investimento atualizado com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInvestment(@PathVariable int id) {
        investmentService.delete(id);
        return ResponseEntity.ok("Investimento removido com sucesso!");
    }
}
