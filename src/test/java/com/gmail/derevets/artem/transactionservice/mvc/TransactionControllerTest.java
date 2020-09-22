package com.gmail.derevets.artem.transactionservice.mvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.derevets.artem.transactionservice.TestResourceContext;
import com.gmail.derevets.artem.transactionservice.api.v1.model.GetTransactionsResponse;
import com.gmail.derevets.artem.transactionservice.api.v1.rest.TransactionController;
import com.gmail.derevets.artem.transactionservice.api.v1.service.TransactionService;
import com.gmail.derevets.artem.transactionservice.api.v1.service.XmlParseService;
import com.gmail.derevets.artem.transactionservice.repository.ClientRepository;
import com.gmail.derevets.artem.transactionservice.repository.TransactionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManagerFactory;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = TransactionController.class)
public class TransactionControllerTest extends TestResourceContext {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private XmlParseService<MultipartFile, GetTransactionsResponse> xmlParseService;
    @MockBean
    private TransactionService transactionService;
    @MockBean
    private EntityManagerFactory entityManagerFactory;
    @MockBean
    private ClientRepository clientRepository;
    @MockBean
    private TransactionRepository transactionRepository;

    @Test
    public void bulkSaveTransactionTest() throws Exception {
        mockMvc.perform(multipart("/api/v1/transaction-service/transaction/upload")
                .file("xmlFile", readTestXmlFile("sunny_day_xml.xml").getBytes()))
                .andExpect(status().isOk());
    }
}
