package ca.digitalarts.dao.impl;

import ca.digitalarts.dao.model.User;
import ca.digitalarts.dao.CreateUser;

import java.util.*;

public class CreateUserImpl implements CreateUser {

    private String id;
    private Map<String, User> userMap = new HashMap<>();

    @Override
    public void buildUser(User user) {
        id = String.valueOf(UUID.randomUUID());
        userMap.put(id, user);
    }

    @Override
    public Map<String, User> getUserMap() {
        return userMap;
    }
}
