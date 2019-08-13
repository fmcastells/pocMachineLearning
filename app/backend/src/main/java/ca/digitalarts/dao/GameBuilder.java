package ca.digitalarts.dao;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public interface GameBuilder {

    List<String> buildGame() throws IOException, GeneralSecurityException;
}
