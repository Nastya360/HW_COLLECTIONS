import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void shouldWinPlayer1() {
        Game game = new Game();
        Player Anya = new Player(12, "Аня", 5000);
        Player Tanya = new Player(15, "Таня", 1000);
        game.register(Anya);
        game.register(Tanya);
        int expected = 1;
        int actual = game.round("Аня", "Таня");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinPlayer2() {
        Game game = new Game();
        Player Anya = new Player(12, "Аня", 50);
        Player Tanya = new Player(15, "Таня", 1000);
        game.register(Anya);
        game.register(Tanya);
        int expected = 2;
        int actual = game.round("Аня", "Таня");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldDraw() {
        Game game = new Game();
        Player Anya = new Player(12, "Аня", 5000);
        Player Tanya = new Player(15, "Таня", 5000);
        game.register(Anya);
        game.register(Tanya);
        int expected = 0;
        int actual = game.round("Аня", "Таня");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPointToAnExceptionWhenPlayerName1NotRegister() {
        Game game = new Game();
        Player Anya = new Player(12, "Аня", 5000);
        Player Tanya = new Player(15, "Таня", 5000);
        game.register(Anya);
        game.register(Tanya);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Вася", "Таня"));
    }

    @Test
    public void shouldPointToAnExceptionWhenPlayerName2NotRegister() {
        Game game = new Game();
        Player Anya = new Player(12, "Аня", 5000);
        Player Tanya = new Player(15, "Таня", 5000);
        game.register(Anya);
        game.register(Tanya);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Таня", "Петя"));
    }

    @Test
    public void shouldPointToAnExceptionWhenAllPlayerNameNotRegister() {
        Game game = new Game();
        Player Anya = new Player(12, "Аня", 5000);
        Player Tanya = new Player(15, "Таня", 5000);
        game.register(Anya);
        game.register(Tanya);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Вася", "Петя"));
    }
}
