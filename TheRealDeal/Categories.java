import java.util.ArrayList;


public class Categories {
    String ctg_name;
    ArrayList<Product> products = new ArrayList<>();
    
    public String getCtg_Name(){
        return this.ctg_name;
    }

    public Categories(String name){
        ctg_name = name;
    }


    public ArrayList<Product> getProduct(){
        return products;
    }
    public void setProduct(ArrayList<Product> products) {
        this.products = products;
    }
    
}
