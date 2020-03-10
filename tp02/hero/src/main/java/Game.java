import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;
    private Arena arena;
    public Game() {
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);   // we don't need a cursor
            screen.startScreen();             // screens must be started
            screen.doResizeIfNecessary();     // resize screen if necessary
        } catch (IOException e) {
            e.printStackTrace();
        }
        arena = new Arena(screen.getTerminalSize().getColumns(), screen.getTerminalSize().getRows());
    }

    private void processKey(KeyStroke key) throws IOException{
        arena.processKey(key);
    }
    private void draw() throws IOException{
        screen.clear();
        arena.draw(screen.newTextGraphics());
        screen.refresh();
    }
    public void run() throws IOException{
        boolean good = true;
        while(good) {
            draw();
            KeyStroke key = screen.readInput();
            processKey(key);
            switch(key.getKeyType()){
                case Character:
                    if(key.getCharacter() == 'q') screen.close();
                    good = false;
                    break;
                case EOF:
                    good = false;
                    break;
            }
            if(arena.verifyMonsterCollisions()){
                screen.close();
                good = false;
            }
        }
    }
}
