import java.util.List;

public class StringRecipe {
    private List<StringTransformer> l;

    public StringRecipe(List<StringTransformer> l) {
        this.l = l;
    }

    StringDrink s;

    public void mix(StringDrink str){
        s = str;
        for(StringTransformer st : l) {
            st.execute(s);
        }
    }

    public String getText(){
        return s.getText();
    }
}
