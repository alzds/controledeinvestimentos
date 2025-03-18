package desenvolvimentogf.controledeinvestimentos.services;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import desenvolvimentogf.controledeinvestimentos.dto.InvestmentDTO;

@Service
public class InvestmentService {
    private final List<InvestmentDTO> investments = new ArrayList<>();

    public InvestmentDTO create(InvestmentDTO investmentDTO) {
        if (investmentDTO.getAmount() <= 0) {
            throw new IllegalArgumentException("O valor investido deve ser maior que 0.");
        }

        if (investmentDTO.getDate()
                .after(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()))) {
            throw new IllegalArgumentException("A data do investimento não pode estar no futuro.");
        }

        InvestmentDTO newInvestment = new InvestmentDTO(
            investmentDTO.getName(),
            investmentDTO.getType(),
            investmentDTO.getAmount(),
            investmentDTO.getDate());

        investments.add(newInvestment);
        return newInvestment;
    }

    public List<InvestmentDTO> list() {
        return investments;
    }

    public InvestmentDTO update(int id, InvestmentDTO investmentDTO) {
        if (investmentDTO.getAmount() <= 0) {
            throw new IllegalArgumentException("O valor investido deve ser maior que 0.");
        }

        if (investmentDTO.getDate()
                .after(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()))) {
            throw new IllegalArgumentException("A data do investimento não pode estar no futuro.");
        }
        
        return investments.set(id, investmentDTO);
    }

    public InvestmentDTO delete(int id) {
        return investments.remove(id);
    }

}
