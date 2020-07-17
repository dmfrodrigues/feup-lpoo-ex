import java.util.HashMap;
import java.util.Map;

public class StringReplacer implements StringTransformer {
    private char fr;
    private char to;

    StringReplacer(char fr, char to){
        this.fr = fr;
        this.to = to;
    }

    HashMap<String, String> m = new HashMap<>();

    @Override
    public void execute(StringDrink drink) {
        String newstr = drink.getText().replace(fr, to);
        m.put(newstr, drink.getText());
        drink.setText(newstr);
    }

    public void undo(StringDrink drink){
        drink.setText(m.get(drink.getText()));
    }
}
