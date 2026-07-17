package it.example.budget.dto;

import java.math.BigDecimal;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DashboardResponse {

    private BigDecimal totalBalance;
    private BigDecimal totalIncome;
    private BigDecimal totalExpense;
    private BigDecimal monthlyBalance;

    /** Category -> total expense amount. */
    private Map<String, BigDecimal> expensesByCategory;

    /** Month label (yyyy-MM) -> balance for that month. */
    private Map<String, BigDecimal> monthlyBalances;
}
