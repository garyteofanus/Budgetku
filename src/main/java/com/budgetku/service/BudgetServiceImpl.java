import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetServiceImpl implements BudgetService {

    private BudgetRepository budgetRepository;

    public BudgetServiceImpl(BudgetRepository budgetRepository){
        this.budgetRepository = budgetRepository;
    }

    @Override
    public Iterable<Budget> getListBudget() {
        return null;
    }

    @Override
    public Budget getBudgetById(int id) {
        return null;
    }

    @Override
    public Budget updateBudget(int id) {
        return null;
    }

    @Override
    public void deleteBudgetById(int id) {
        return null;
    }

    @Override
    public String getSummary() {
        return null;
    }

    