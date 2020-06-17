package org.kek.camel.process;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.kek.backend.model.User;
import org.kek.backend.service.ConverterService;
import org.kek.camel.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * Processor implementation which transform data in camel route
 * to list of users
 *
 * @version 1.01 17 Jun 2020
 * @author Uladzislau Biadrytski
 *
 */
@Component
public class TransformToUsersList implements Processor {

    @Autowired
    private ConverterService converterService;

    @Override
    public void process(Exchange exchange) throws Exception {
        String payload = exchange.getIn().getBody(String.class);

        List<User> users = converterService.convertJsonToListOfUsers(payload);

        List<UserDto> result = users
                .stream()
                .map(user ->
                        new UserDto(user.getUsername(), user.getPassword()))
                .collect(Collectors.toList());

        exchange.getIn().setBody(
                result
        );
    }
}
