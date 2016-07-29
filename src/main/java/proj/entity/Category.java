package proj.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SCIP on 26.07.2016.
 */
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String categoryName;
    @OneToMany(mappedBy = "category")
    List<Product> productList = new ArrayList<Product>();
    @ManyToMany
    @JoinTable(name = "category_listOfProperties", joinColumns =
    @JoinColumn(name = "fk_category"), inverseJoinColumns =
    @JoinColumn(name = "fk_listOfProperties"))
    List<ListOfProperties> listOfProperties = new ArrayList<ListOfProperties>();

    public Category() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
