package ca.digitalarts.dao.impl;

import ca.digitalarts.dao.AlgorithmBuilder;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomUtils;

public class AlgorithmBuilderImpl implements AlgorithmBuilder {

    @Override
    public String betAnswer() {
        return RandomUtils.nextInt(0, 3) + " x " + RandomUtils.nextInt(0, 3);
    }
}
