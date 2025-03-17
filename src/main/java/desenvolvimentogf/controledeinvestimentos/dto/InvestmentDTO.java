package desenvolvimentogf.controledeinvestimentos.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvestmentDTO {
    private String name;
    private String type;
    private double amount;
    private Date date;
}
