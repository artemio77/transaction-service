package com.gmail.derevets.artem.transactionservice.service;

import com.gmail.derevets.artem.transactionservice.TestResourceContext;
import com.gmail.derevets.artem.transactionservice.api.v1.model.GetTransactionsResponse;
import com.gmail.derevets.artem.transactionservice.api.v1.service.XmlParseService;
import com.gmail.derevets.artem.transactionservice.api.v1.service.impl.TransactionsXmlParseServiceImpl;
import org.assertj.core.api.Assertions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = XmlParseServiceImplTest.TestConfig.class)
public class XmlParseServiceImplTest extends TestResourceContext {
    @Autowired
    private XmlParseService<MultipartFile, GetTransactionsResponse> xmlParseService;

    @TestConfiguration
    public static class TestConfig {
        @Bean
        public XmlParseService<MultipartFile, GetTransactionsResponse> xmlParseService(MessageFactory messageFactory) {
            return new TransactionsXmlParseServiceImpl(messageFactory);
        }

        @Bean
        public MessageFactory messageFactory() throws SOAPException {
            return MessageFactory.newInstance();
        }
    }

    @Test
    public void sunnyDayParse() {
        MultipartFile multipartFile = readTestXmlFile("sunny_day_xml.xml");
        GetTransactionsResponse parse = xmlParseService.parse(multipartFile);
        Assertions.assertThat(parse).isNotNull();
        Assertions.assertThat(parse.getTransactions().size()).isEqualTo(12);
    }

    @Test(expected = RuntimeException.class)
    public void rainyDayParse() {
        MultipartFile multipartFile = readTestXmlFile("rainy_day_xml.xml");
        xmlParseService.parse(multipartFile);
    }


}
