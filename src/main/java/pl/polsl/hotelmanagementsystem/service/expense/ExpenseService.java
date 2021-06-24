package pl.polsl.hotelmanagementsystem.service.expense;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.polsl.hotelmanagementsystem.service.room.RoomRepository;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final RoomRepository roomRepository;
    @Scheduled(fixedRate = 10_000)  // change here to have lose money faster
    private void incurExpense(){

        Expense expense = Expense.builder()
                .amount(Math.random()*100d)
                .expenseType(ExpenseType.SUPPLIES)
                .date(new Date())
                .room(roomRepository.findById(1l).orElseThrow())
                .build();
        expenseRepository.save(expense);
    }

    public List<Expense> getExpenses(){
        return expenseRepository.findAll();
    }
}
