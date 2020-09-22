package com.gmail.derevets.artem.transactionservice.api.v1.service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.ws.soap.SoapMessage;

public interface XmlParseService<T, V> {
    V parse(T t);
}
