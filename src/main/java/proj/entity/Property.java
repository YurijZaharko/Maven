package proj.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SCIP on 26.07.2016.
 */
@Entity
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String propertyName;

    @OneToMany(mappedBy = "property")
    List<ListOfProperties> listOfProperties = new ArrayList<ListOfProperties>();
    public Property() {
    }
}
