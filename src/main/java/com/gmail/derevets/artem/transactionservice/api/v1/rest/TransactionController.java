package com.gmail.derevets.artem.transactionservice.api.v1.rest;

import com.gmail.derevets.artem.transactionservice.api.v1.model.GetTransactionsResponse;
import com.gmail.derevets.artem.transactionservice.api.v1.model.Transaction;
import com.gmail.derevets.artem.transactionservice.api.v1.service.TransactionService;
import com.gmail.derevets.artem.transactionservice.api.v1.service.XmlParseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/transaction-service/transaction")
public class TransactionController {
    private static final Logger log = LoggerFactory.getLogger(TransactionController.class);
    private final TransactionService transactionService;
    private final XmlParseService<MultipartFile, GetTransactionsResponse> multipartFileXmlParseService;

    @Autowired
    public TransactionController(TransactionService transactionService,
                                 XmlParseService<MultipartFile, GetTransactionsResponse> multipartFileXmlParseService) {
        this.transactionService = transactionService;
        this.multipartFileXmlParseService = multipartFileXmlParseService;

    }

    @PostMapping(value = "/upload", produces = MediaType.APPLICATION_XML_VALUE)
    public List<Transaction> bulkSave(@RequestParam("xmlFile") MultipartFile multipartFile) {
        GetTransactionsResponse request = multipartFileXmlParseService.parse(multipartFile);
        if (request == null) {
            return Collections.emptyList();
        }
        return transactionService.bulkSave(request.getTransactions());
    }

}
