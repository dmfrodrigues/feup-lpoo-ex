import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.Random;

public class Monster extends Element{
    public Monster(Position position){
        super(position);
    }
    public void draw(TextGraphics graphics) throws IOException {
        graphics.setForegroundColor(TextColor.Factory.fromString("#00FF00"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "M");
    }
    public Position move() {
        Random random = new Random();
        Position pos = new Position(getPosition().getX() + random.nextInt(3) - 1,
                                    getPosition().getY() + random.nextInt(3) - 1);
        return pos;
    }
}
