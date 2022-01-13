import java.util.ArrayList;
import java.util.List;

public class Stock {
    List<Categories> categories = new ArrayList<>();
    public List<Categories> getCategorie(){
        return categories;
    }
    public void setCategorie(List<Categories> categories) {
        this.categories = categories;
    }
    
}
