package proj.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SCIP on 26.07.2016.
 */
@Entity
public class ListOfProperties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany
    @JoinTable(name = "category_listOfProperties", joinColumns =
    @JoinColumn(name = "fk_listOfProperties"), inverseJoinColumns =
    @JoinColumn(name = "fk_category"))
    private List<Category> categoryList = new ArrayList<Category>();

    @ManyToMany
    @JoinTable(name = "property_listOfProperties", joinColumns =
    @JoinColumn(name = "fk_listOfProperties"), inverseJoinColumns =
    @JoinColumn(name = "fk_property"))
    private List<Property> propertyList = new ArrayList<Property>();

    public ListOfProperties() {
    }


}
