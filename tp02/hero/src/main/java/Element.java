import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;

public abstract class Element {
    private Position position;
    public Element(Position position){
        this.position = position;
    }
    public void     setPosition(Position position){ this.position = position; }
    public Position getPosition(){ return position; }
    public abstract void draw(TextGraphics graphics) throws IOException;
}
