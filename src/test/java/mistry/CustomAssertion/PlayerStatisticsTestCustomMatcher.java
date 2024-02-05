package mistry.CustomAssertion;

import mistry.Matchers.src.main.java.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerStatisticsTestCustomMatcher {

    @Test
    public void playerConstructorAssignsName(){
        Player player = new Player("RobinSmith", 30);
        mistry.CustomAssertion.PlayerAssert.assertThat(player).hasName("RobinSmith");
    }
}