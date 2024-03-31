package mistry.stubbingVoid;

import mistry.stubbingVoid.src.main.java.ChessPlayer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ChessPlayerTest {

    @Disabled
    public void testAssignCategorySpy() throws Exception{

        ChessPlayer chessPlayer = new ChessPlayer("Magnus", 30);
        ChessPlayer chessPlayerSpy = Mockito.spy(chessPlayer);

        // void method
        doNothing().when(chessPlayerSpy).assignCategory();

        // this calls the Actual ChessPlayer class ,there is NO MOCK INVOLVED.
        chessPlayerSpy.assignCategory();

        assertEquals("Senior", chessPlayerSpy.getCategory());

    }

    @Test
    public void testAssignCategoryMock() throws Exception{

        ChessPlayer chessPlayerMock = Mockito.mock(ChessPlayer.class);

        when(chessPlayerMock.getAge()).thenReturn(30);
        doCallRealMethod().when(chessPlayerMock).assignCategory();
        doCallRealMethod().when(chessPlayerMock).getCategory();
        chessPlayerMock.assignCategory();

        assertEquals("Senior", chessPlayerMock.getCategory());
    }

    public void testAssignCategoryMockException() throws Exception{

        // Junit5 way of throwing Exceptions
         Assertions.assertThrows(Exception.class, () -> {
             // Code that throws Exception
            ChessPlayer chessPlayerMock = Mockito.mock(ChessPlayer.class);
            doThrow(Exception.class).when(chessPlayerMock).assignCategory();
            chessPlayerMock.assignCategory();
         });
    }

    @Test
    public void testAssignScoreStats(){

        ChessPlayer chessPlayer = new ChessPlayer("Magnus", 30);
        ChessPlayer chessPlayerSpy = Mockito.spy(chessPlayer);

        doAnswer((chessP) -> {
            ChessPlayer player = (ChessPlayer)chessP.getMock();
            player.setWins(3);
            player.setPoints(9);
            return null;
        }).when(chessPlayerSpy).assignScoreStats();

        chessPlayerSpy.assignScoreStats();
        assertSame(3, chessPlayerSpy.getWins());
        assertSame(9, chessPlayerSpy.getPoints());

    }

}
