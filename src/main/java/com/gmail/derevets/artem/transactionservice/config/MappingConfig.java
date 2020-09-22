package com.gmail.derevets.artem.transactionservice.config;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.gmail.derevets.artem.transactionservice.api.v1.model.GetTransactionsResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.io.ByteArrayInputStream;

@Configuration
public class MappingConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setSkipNullEnabled(true)
                .setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper;
    }

    @Bean
    public MessageFactory messageFactory() throws SOAPException {
        return MessageFactory.newInstance();
    }

}
