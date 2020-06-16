package org.kek.camel.service;

import org.kek.backend.model.User;

import java.util.List;

/**
 *
 * Camel context consumer service
 *
 * @version 1.01 16 Jun 2020
 * @author Uladzislau Biadrytski
 *
 */
public interface ConsumerService {

    List<User> getUsersFromScheduleQueue();
}
