import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int width, height;
    private Hero hero;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;
    public Arena(int width, int height){
        this.width = width;
        this.height = height;
        hero = new Hero(new Position(10, 10));
        walls = createWalls();
        coins = createCoins();
        monsters = createMonsters();
    }
    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(new Position(c, 0)));
            walls.add(new Wall(new Position(c, height - 1)));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(new Position(0, r)));
            walls.add(new Wall(new Position(width - 1, r)));
        }

        return walls;
    }
    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Position pos;
            boolean good;
            do {
                pos = new Position(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);
                good = true;
                if(!canHeroMove(pos)) good = false;
                for(Coin coin: coins) if(coin.getPosition().equals(pos)){ good = false; break; }
                if(hero.getPosition().equals(pos)) good = false;
            } while(!good);
            coins.add(new Coin(pos));
        }
        return coins;
    }
    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Position pos;
            boolean good;
            do {
                pos = new Position(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);
                good = true;
                if(!canHeroMove(pos)) good = false;
                for(Monster m: monsters) if(m.getPosition().equals(pos)){ good = false; break; }
                if(hero.getPosition().equals(pos)) good = false;
            } while(!good);
            monsters.add(new Monster(pos));
        }
        return monsters;
    }
    private void moveHero(Position position) {
        if (canHeroMove(position))
            hero.setPosition(position);
    }
    public void processKey(KeyStroke key) throws IOException {
        switch(key.getKeyType()){
            case ArrowUp: moveHero(hero.moveUp()); break;
            case ArrowDown: moveHero(hero.moveDown()); break;
            case ArrowLeft: moveHero(hero.moveLeft()); break;
            case ArrowRight: moveHero(hero.moveRight()); break;
        }
        retrieveCoins();
        moveMonsters();
    }
    public void draw(TextGraphics graphics) throws IOException{
        graphics.setBackgroundColor(TextColor.Factory.fromString("#C2B280"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');

        for (Wall wall : walls   ) wall.draw(graphics);
        for (Coin coin : coins   ) coin.draw(graphics);
        for (Monster m : monsters) m   .draw(graphics);

        hero.draw(graphics);
    }
    private boolean canHeroMove(Position position){
        if(!(0 < position.getX() && position.getX() < width-1 &&
             0 < position.getY() && position.getY() < height-1)) return false;
        for (Wall wall : walls){
            if(wall.getPosition().equals(position)) return false;
        }
        return true;
    }
    private void retrieveCoins(){
        for(int i = 0; i < coins.size(); ++i){
            if(coins.get(i).getPosition().equals(hero.getPosition())){
                coins.remove(i);
                return;
            }
        }
    }
    private void moveMonsters(){
        final int N_TRIES = 10;
        for(int i = 0; i < monsters.size(); ++i){
            for(int j = 0; j < N_TRIES; ++j){
                Position pos = monsters.get(i).move();
                if(canHeroMove(pos)){
                    monsters.get(i).setPosition(pos);
                    break;
                }
            }
        }
    }
    public boolean verifyMonsterCollisions(){
        for(Monster m : monsters){
            if(m.getPosition().equals(hero.getPosition())) return true;
        }
        return false;
    }
}
