package mistry.Matchers;

import mistry.Matchers.src.main.java.Player;
import mistry.Matchers.src.main.java.PlayerStatistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class PlayerStatisticsTest {

    private Player playerPatrickUnderThirty;
    private PlayerStatistics statisticsOfPatrickUnderThirty;

    @BeforeEach
    public void setup(){
        playerPatrickUnderThirty = new mistry.Matchers.src.main.java.Player("Patrick", 27);
        statisticsOfPatrickUnderThirty = new PlayerStatistics(playerPatrickUnderThirty, 3, 3);
    }

    @Test
    public void playerNameEqual() throws InterruptedException {
        mistry.Matchers.src.main.java.Player player2 = new Player("Patrick", 27);
        assertEquals(player2,playerPatrickUnderThirty);
    }

    @Test
    public void playerNamesNotEqual(){
        Player player2 = new Player("Kalvin", 25);
        assertNotEquals(player2,playerPatrickUnderThirty);
    }

    @Test
    public void youngerPlayerSame() {
        System.out.println("test 3");
        Player player2 = new Player("Patrick", 250);
        // TODO
        //assertThat(PlayerStatistics.getYoungerPlayer(playerPatrickUnderThirty, player2).isSameAs(player2);
    }

    @Test
    public void underThirtyTrue(){
        System.out.println("test 4");
        // TODO
       // assertThat(statisticsOfPatrickUnderThirty.underThirty()).isTrue();
    }

    @Test
    public void underThirtyFalse(){
        System.out.println("test 5");
        Player player1 = new Player("Patrick", 37);
        PlayerStatistics statistics = new PlayerStatistics(player1, 3, 3);
        // TODO
        // assertThat(statistics.underThirty()).isFalse();
    }

    @Test
    public void csvReportNull(){
        System.out.println("test 6");
        PlayerStatistics statistics = new PlayerStatistics(playerPatrickUnderThirty, 0, 0);
        //TODO
        //assertThat(statistics.createCsvRecord()).isNull();
    }

    @Test
    public void csvReportNotNull(){
        System.out.println("test 7");
        PlayerStatistics statistics = new PlayerStatistics(playerPatrickUnderThirty, 3, 3);
        //TODO
        // assertThat(statistics.createCsvRecord()).isNotNull();
    }

    @Test
    public void getCsvStatsRecord(){
        System.out.println("test 8");
        PlayerStatistics statistics = new PlayerStatistics(playerPatrickUnderThirty, 4, 8);
        Double[] expectedArray = {2d, 0.5};
        //TODO
        //assertThat(statistics.createCsvRecord()).isEqualTo(expectedArray);
    }
}
