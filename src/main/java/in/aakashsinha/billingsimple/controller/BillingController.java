package in.aakashsinha.billingsimple.controller;

import in.aakashsinha.billingsimple.entity.Billing;
import in.aakashsinha.billingsimple.model.BillingModel;
import in.aakashsinha.billingsimple.model.RestResponseBody;
import in.aakashsinha.billingsimple.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/billing/v1")
public class BillingController {

    @Autowired
    BillingService billingService;

    @PostMapping("/add")
    public ResponseEntity<RestResponseBody<Object>> addBilling(@RequestBody BillingModel billingModel) {
        RestResponseBody<Object> response = RestResponseBody.builder()
                .data(billingService.addBilling(billingModel))
                .timestamp(Instant.now())
                .message("success")
                .status(HttpStatus.CREATED)
                .build();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<RestResponseBody<Object>> getAllBills() {


        RestResponseBody<Object> response = RestResponseBody.builder()
                .data(billingService.getAllBills())
                .timestamp(Instant.now())
                .message("success")
                .status(HttpStatus.CREATED)
                .build();

        return new ResponseEntity<>(response, HttpStatus.OK);


    }
}
