package com.gmail.derevets.artem.transactionservice.api.v1.service.impl;

import com.gmail.derevets.artem.transactionservice.api.v1.model.GetTransactionsResponse;
import com.gmail.derevets.artem.transactionservice.api.v1.service.XmlParseService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ws.soap.SoapMessage;
import org.w3c.dom.Document;

import javax.management.modelmbean.XMLParseException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@Service
public class TransactionsXmlParseServiceImpl implements XmlParseService<MultipartFile, GetTransactionsResponse> {
    private final MessageFactory messageFactory;

    public TransactionsXmlParseServiceImpl(MessageFactory messageFactory) {
        this.messageFactory = messageFactory;
    }

    @Override
    public GetTransactionsResponse parse(MultipartFile xmlFile) {
        try {
            ByteArrayInputStream soapStringStream = new ByteArrayInputStream(xmlFile.getBytes());
            SOAPMessage soapMessage = messageFactory.createMessage(new MimeHeaders(), soapStringStream);
            Unmarshaller unmarshaller = JAXBContext.newInstance(GetTransactionsResponse.class).createUnmarshaller();
            Document document = soapMessage.getSOAPBody().extractContentAsDocument();
            return (GetTransactionsResponse) unmarshaller.unmarshal(document);
        } catch (IOException | SOAPException | JAXBException e) {
            //TODO specify exception
            throw new RuntimeException(e);
        }
    }
}
