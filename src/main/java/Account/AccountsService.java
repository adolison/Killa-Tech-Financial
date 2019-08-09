package Account;

import Bill.Bill;
import Customer.Customer;
import Customer.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Bill.BillsRepository;
import Bill.BillsService;

import java.util.Optional;

@Service
public class AccountsService {

    private final Logger logger = LoggerFactory.getLogger(AccountsService.class);
    private AccountsRepository accountRepo;
    private CustomerRepository customerRepo;
    private BillsRepository billRepo;
    private BillsService billsService;

    @Autowired
    public AccountsService(AccountsRepository accountRepo,CustomerRepository customerRepo){
        this.accountRepo = accountRepo;
        this.customerRepo = customerRepo;
    }

    public Iterable<Accounts> findAll(){
        logger.info("Getting all accounts");
        Iterable<Accounts> accounts = accountRepo.findAll();
        return accounts;
    }

    /*public Bill addBill(Long id, Bill bill){
        Accounts account = find(id);
        logger.info("Adding Bill: {} to {}", bill.getId(), account.getId());
        bill.setAccount(account);
        bill = billRepo.save(bill);
        return bill;
    }*/

    public Accounts find(Long id) {
        logger.info("Getting account with id:{}", id);
        Optional<Accounts> accountOption = accountRepo.findById(id);
        return accountOption.get();
    }

    public Accounts create(Accounts accounts) {
        logger.info("Creating an account with name: {}", accounts.getNickname());
        accounts = accountRepo.save(accounts);
        return accounts;
    }


}
