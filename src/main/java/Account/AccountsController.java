package Account;


import Bill.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Bill.BillsService;


import java.util.ArrayList;
import java.util.List;

import static javafx.scene.input.KeyCode.K;

@RestController
public class AccountsController {
    private AccountsService accountsService;


    @Autowired
    public AccountsController(AccountsService accountsService){
        this.accountsService = accountsService;
    }





    @GetMapping("/accounts")
    public ResponseEntity<Iterable<Accounts>> getAll(){
        Iterable<Accounts> accounts = accountsService.findAll();
        ResponseEntity<Iterable<Accounts>> responseEntity = new ResponseEntity<>(accounts, HttpStatus.OK);
        return responseEntity;
    }

  /* @PostMapping("/accounts/{accountId}/bills")
    public ResponseEntity<Bill> postAddBilltoAccount(@PathVariable("id") Long id, @RequestBody Bill bill){
        bill = accountsService.addBill(id,bill); //.addAlbum(id, album);
        return new ResponseEntity<>(bill, HttpStatus.CREATED);
    }*/

    @PostMapping("/accounts")
    public ResponseEntity<Accounts> post(@RequestBody Accounts accounts){
        accounts = accountsService.create(accounts);
        return new ResponseEntity<>(accounts, HttpStatus.CREATED);
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity<Accounts> get(@PathVariable("id") Long id){
        Accounts accounts = accountsService.find(id);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }



}
