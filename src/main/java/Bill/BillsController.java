package Bill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillsController {
    private BillsService billsService;

    @Autowired
    public BillsController(BillsService billsService){
        this.billsService = billsService;
    }

    @GetMapping("/bills/{id}")
    public ResponseEntity<Bill> get(@PathVariable("id") Long id){
        Bill bill = billsService.find(id);
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }



}
