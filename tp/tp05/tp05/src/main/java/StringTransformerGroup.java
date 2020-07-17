import java.util.Collections;
import java.util.List;

public class StringTransformerGroup implements StringTransformer {
    private List<StringTransformer> l;

    public StringTransformerGroup(List<StringTransformer> l) {
        this.l = l;
    }

    @Override
    public void execute(StringDrink drink){
        for(StringTransformer st : l) {
            st.execute(drink);
        }
    }

    @Override
    public void undo(StringDrink drink) {
        Collections.reverse(l);
        for(StringTransformer st : l) {
            st.undo(drink);
        }
        Collections.reverse(l);
    }
}
