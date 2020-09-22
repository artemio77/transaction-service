package com.gmail.derevets.artem.transactionservice;

import com.gmail.derevets.artem.transactionservice.exception.TestExpectationException;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

public class TestResourceContext {


    protected MultipartFile readTestXmlFile(String resource)  {
        try {
            URL url = Thread.currentThread().getContextClassLoader().getResource(resource);
            assert url != null;
            return new MockMultipartFile("test.xlsx", new FileInputStream(new File(url.getPath())));
        } catch (IOException e) {
            throw new TestExpectationException("Failed to parse resource",e);
        }
    }
}
