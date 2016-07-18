import javax.persistence.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "Menu")
@NamedQuery(name = "Menu.getAll", query = "SELECT m from Menu m")
public class Menu {
    @Id
    @GeneratedValue
    private long id;
    private String dish;
    private float price;
    private float weight;
    private int discount;

    public Menu(String dish, float price, float weight, int discount) {
        this.dish = dish;
        this.price = price;
        this.weight = weight;
        this.discount = discount;
    }

    public Menu() {
    }

    @Override
    public String toString() {
        return String.format("№ %d, %s, %.2f $, %.2f грамм, скидка: %d%%", id, dish, price, weight, discount);
//
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
