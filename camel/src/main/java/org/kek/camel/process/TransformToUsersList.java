package org.kek.camel.process;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.kek.backend.model.User;
import org.kek.backend.service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransformToUsersList implements Processor {

    @Autowired
    private ConverterService converterService;

    @Override
    public void process(Exchange exchange) throws Exception {
        String payload = exchange.getIn().getBody(String.class);

        List<User> users = converterService.convertJsonToListOfUsers(payload);

        exchange.getIn().setBody(users);
    }
}
