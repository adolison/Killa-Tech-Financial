package Bill;

import Account.Accounts;
import Account.AccountsRepository;
import Account.AccountsService;
import Customer.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillsService {

    private static final Logger logger = LoggerFactory.getLogger(AccountsService.class);
    private static BillsRepository billRepo;
    private AccountsRepository accountRepo;

    @Autowired
    public BillsService(BillsRepository billRepo,AccountsRepository accountRepo){
        this.billRepo = billRepo;
        this.accountRepo = accountRepo;

    }

    @Autowired
    public BillsService(BillsRepository billRepo){//, AlbumRepo albumRepo){
        this.billRepo = billRepo;
        //this.albumRepo = albumRepo;
    }

    public Iterable<Bill> findAll(){
        logger.info("Getting all accounts");
        Iterable<Bill> bills = billRepo.findAll();
        return bills;
    }

    public Bill find(Long id){
        logger.info("Getting Bill with id", id);
        Optional<Bill> billOption = billRepo.findById(id);
        return billOption.get();
    }

    /*public static Bill find(Long id){
        logger.info("Getting Wutang Member with id: {}", id);
        Optional<Bill> billOptional = billRepo.findById(id);
        return billOptional.get();
    }*/

   /* public Bill addBill(Long accountId, Bill bill){
        Accounts accounts = find(accountId);

        Bill theBill = find(id);
        //bill.se
        bill = BillsRepository.save(theBill);
        return bill;
    }*/

    public Bill create(Bill bill){
        logger.info("Creating Bill", bill);
        bill = billRepo.save(bill);
        return bill;
    }



   /* public Bill update(Bill bill){
        logger.info("Updating Wutang Member with name: {}", bill.getId());
        bill = BillsRepository.save(bill.getId());
        return bill;
    }*/
}
