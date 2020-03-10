import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;

public class Wall extends Element {
    public Wall(Position position){
        super(position);
    }
    public void draw(TextGraphics graphics) throws IOException {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FF6000"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "I");
    }
}
