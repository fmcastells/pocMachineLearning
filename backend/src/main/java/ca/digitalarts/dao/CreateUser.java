package ca.digitalarts.dao;

import ca.digitalarts.dao.model.User;

import java.util.Map;

public interface CreateUser {

    void buildUser(User user);

    Map<String, User> getUserMap();
}
