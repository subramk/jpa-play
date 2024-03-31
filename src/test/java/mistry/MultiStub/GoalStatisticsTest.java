package mistry.MultiStub;

import mistry.MultiStub.src.main.java.GoalStatistics;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GoalStatisticsTest {

    // @Mock TODO How to refer to inner class GoalService;

    @InjectMocks
    GoalStatistics goalStatistics;

    @Test
    public void testGoalsPerGame() throws Exception {

//        String playerName = "Player";
//
//        when(goalStatistics.getClass().getEnclosingClass()).thenReturn()
//
//        //  Fix Test
//        //
//        when(goalsService.getGoals(playerName)).thenReturn(100).thenReturn(10);
//
//        Integer goalsHigh = goalStatistics.goalsPerGame(playerName, 10);
//        assertThat(goalsHigh, is(10));
//
//        Integer goalsLow = goalStatistics.goalsPerGame(playerName, 10);
//        assertThat(goalsLow, is(1));
////
//        System.out.println(goalStatistics.goalsPerGame(playerName, 10));
//        System.out.println(goalStatistics.goalsPerGame(playerName, 10));
//        System.out.println(goalStatistics.goalsPerGame(playerName, 10));
    }

}
