import org.hibernate.sql.Select;
import proj.control.Control;
import proj.control.Scann;
import proj.dao.*;
import proj.dao.implementation.*;
import proj.entity.*;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Iterator;
import java.util.List;

/**
 * Created by SCIP on 29.07.2016.
 */
public class Main {
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("primary");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();
    private static final BrandDao BRAND_DAO = new BrandDaoImplementation(Brand.class, entityManager);
    private static final CountryDao COUNTRY_DAO = new CountryDaoImplementation(Country.class, entityManager);
    private static final CategoryDao CATEGORY_DAO = new CategoryDaoImplementation(Category.class, entityManager);
    private static final StringPropertiesDao STRING_PROPERTIES_DAO = new StringPropertiesDaoImplementation(StringProperties.class, entityManager);
    private static final ValueOfStringPropertiesDao VALUE_OF_STRING_PROPERTIES_DAO = new ValueOfStringPropertiesDaoImplement(ValueOfStringProperties.class, entityManager);
    private static final ValueOfIntegerPropertiesDao VALUE_OF_INTEGER_PROPERTIES_DAO = new ValueOfIntegerPropertiesDaoImplement(ValueOfIntegerProperties.class, entityManager);
    private static final IntegerPropertiesDao INTEGER_PROPERTIES_DAO = new IntegerPropertiesDaoImplementation(IntegerProperties.class, entityManager);
    private static final ProductDao PRODUCT_DAO = new ProductDaoImplementation(Product.class, entityManager);

    public static void main(String[] args) {
        Scann scann = new Scann();
        Control control = new Control(scann);

        List<Category> categoryListTest = entityManager.createQuery("SELECT category FROM Category category JOIN FETCH category.productList product where product.partNumber=:partNumber",
                Category.class).setParameter("partNumber", "DTSE9_16GB_(DTSE9H/16GB)").getResultList();
        System.out.println(categoryListTest);


        boolean isRun = true;
        while (isRun){
            switch (control.mainMenu()){
                case 1: {
                    switch (control.subMenu()){
                        case 1:{
                            BRAND_DAO.save(new Brand(scann.readString("Brand name?")));
                            break;
                        }
                        case 2:{
                            BRAND_DAO.update(new Brand(scann.readString("Brand name?")));
                            break;
                        }
                        case 3:{
                            BRAND_DAO.delete(new Brand(scann.readString("Brand name?")));
                            break;
                        }
                        case 4:{
                            Brand brand = BRAND_DAO.find(scann.readInt("Id of item?"));
                            System.out.println(brand);
                            break;
                        }
                        case 5:{
                            List<Brand> brandList= BRAND_DAO.findAll();
                            for (Iterator<Brand> iterator = brandList.iterator(); iterator.hasNext(); ) {
                                Brand bran = iterator.next();
                                System.out.println(bran);
                            }
                        }
                        default:{
                            break;
                        }

                    }
                    break;
                }
                case 2: {
                    switch (control.subMenu()){
                        case 1:{
                            COUNTRY_DAO.save(new Country(scann.readString("Country name?")));
                            break;
                        }
                        case 2:{
                            COUNTRY_DAO.update(new Country(scann.readString("Country name?")));
                            break;
                        }
                        case 3:{
                            COUNTRY_DAO.delete(new Country(scann.readString("Country name?")));
                            break;
                        }
                        case 4:{
                            Country Country = COUNTRY_DAO.find(scann.readInt("Id of item?"));
                            System.out.println(Country);
                            break;
                        }
                        case 5:{
                            List<Country> CountryList= COUNTRY_DAO.findAll();
                            for (Iterator<Country> iterator = CountryList.iterator(); iterator.hasNext(); ) {
                                Country bran = iterator.next();
                                System.out.println(bran);
                            }
                            break;
                        }
                        default:{
                            break;
                        }
                    }
                    break;
                }
                case 3: {
                    switch (control.subMenu()){
                        case 1:{
                            CATEGORY_DAO.save(new Category(scann.readString("Category name?")));
                            break;
                        }
                        case 2:{
                            CATEGORY_DAO.update(new Category(scann.readString("Category name?")));
                            break;
                        }
                        case 3:{
                            CATEGORY_DAO.delete(new Category(scann.readString("Category name?")));
                            break;
                        }
                        case 4:{
                            Category Category = CATEGORY_DAO.find(scann.readInt("Id of item?"));
                            System.out.println(Category);
                            break;
                        }
                        case 5:{
                            List<Category> CategoryList= CATEGORY_DAO.findAll();
                            for (Iterator<Category> iterator = CategoryList.iterator(); iterator.hasNext(); ) {
                                Category category = iterator.next();
                                System.out.println(category);
                            }
                            break;
                        }
                        default:{
                            break;
                        }
                    }
                    break;
                }
                case 4: {
                    switch (control.subMenu()){
                        case 1:{
                            String propertyName = scann.readString("String Property name?");
                            StringProperties stringProperties = new StringProperties(propertyName);
                            STRING_PROPERTIES_DAO.save(stringProperties);
                            boolean addValue = true;
                            String valueOfStringProperty = null;
                            ValueOfStringProperties valueOfStringProperties = null;
                            while (addValue){
                                System.out.println("1. Add value");
                                System.out.println("0. Exit");
                                switch (scann.readInt("Choose number")){
                                    case 1:{
                                        valueOfStringProperty = scann.readString("String value&");
                                        valueOfStringProperties = new ValueOfStringProperties(valueOfStringProperty);
                                        VALUE_OF_STRING_PROPERTIES_DAO.save(valueOfStringProperties);
                                    }
                                    default:{
                                        addValue = false;
                                    }
                                    stringProperties.getValueOfStringPropertiesList().add(valueOfStringProperties);
                                    STRING_PROPERTIES_DAO.save(stringProperties);
                                }
                            }
                            break;
                        }
                        case 2:{
                            String propertyName = scann.readString("String Property name?");
                            StringProperties stringProperties = new StringProperties(propertyName);
                            STRING_PROPERTIES_DAO.update(stringProperties);
                            boolean addValue = true;
                            String valueOfStringProperty = null;
                            ValueOfStringProperties valueOfStringProperties = null;
                            while (addValue){
                                System.out.println("1. Add value");
                                System.out.println("0. Exit");
                                switch (scann.readInt("Choose number")){
                                    case 1:{
                                        valueOfStringProperty = scann.readString("String value&");
                                        valueOfStringProperties = new ValueOfStringProperties(valueOfStringProperty);
                                        VALUE_OF_STRING_PROPERTIES_DAO.update(valueOfStringProperties);
                                    }
                                    default:{
                                        addValue = false;
                                    }
                                    stringProperties.getValueOfStringPropertiesList().add(valueOfStringProperties);
                                    STRING_PROPERTIES_DAO.save(stringProperties);
                                }
                            }
                            break;
                        }
                        case 3:{
                            StringProperties stringProperties = new StringProperties(scann.readString("String Property name?"));
                            STRING_PROPERTIES_DAO.delete(stringProperties);
                            break;
                        }
                        case 4:{
                            StringProperties stringProperties = STRING_PROPERTIES_DAO.find(scann.readInt("Id of item?"));
                            System.out.println(stringProperties);
                            break;
                        }
                        case 5:{
                            List<StringProperties> StringPropertiesList= STRING_PROPERTIES_DAO.findAll();
                            for (Iterator<StringProperties> iterator = StringPropertiesList.iterator(); iterator.hasNext(); ) {
                                StringProperties bran = iterator.next();
                                System.out.println(bran);
                            }
                            break;
                        }
                        default:{
                            break;
                        }
                    }
                    break;
                }
                case 5: {
                    String propertyName = scann.readString("Integer property name?");
                    IntegerProperties integerProperties = new IntegerProperties(propertyName);
                    INTEGER_PROPERTIES_DAO.save(integerProperties);
                    boolean addValue = true;
                    Integer valueOfIntegerProperty = null;
                    ValueOfIntegerProperties valueOfIntegerProperties = null;
                    while (addValue){
                        System.out.println("1. Add value");
                        System.out.println("0. Exit");
                        switch (scann.readInt("Choose number")){
                            case 1:{
                                valueOfIntegerProperty = scann.readInt("Integer value?");
                                valueOfIntegerProperties = new ValueOfIntegerProperties(valueOfIntegerProperty);
                                VALUE_OF_INTEGER_PROPERTIES_DAO.save(valueOfIntegerProperties);
                            }
                            default:{
                                addValue = false;
                            }
                            integerProperties.getValueOfIntegerPropertiesList().add(valueOfIntegerProperties);
                            INTEGER_PROPERTIES_DAO.save(integerProperties);
                        }
                    }
                    break;
                }
                case 6:{
                    break;
                }
                case 7: {
                    String productName = scann.readString("product Name ?");
                    String partNumber = scann.readString("part Number ?");
                    int price = scann.readInt("Price ?");
                    Product product = new Product(price, productName, partNumber);

//
//                    List<Brand> brandList = entityManager.createQuery("SELECT brand from Brand brand", Brand.class).getResultList();
//                    for (Brand b:brandList) {
//                        System.out.print(b.getBrandName() + ", ");
//                    }
//                    System.out.println();
//                    String brandName = scann.readString("Choose Brand name?");
//                    Brand brand = entityManager.createQuery("SELECT brand FROM Brand brand where brand.brandName=:brand",
//                            Brand.class).setParameter("brand",brandName).getSingleResult();
//                    product.setBrand(brand);

                    List<Country> countryList = entityManager.createQuery("SELECT country from Country country", Country.class).getResultList();
                    for (Country c:countryList) {
                        System.out.print(c + " ");
                    }
                    System.out.println();
                    String countryName = scann.readString("Choose country");
                    Country country = entityManager.createQuery("SELECT c FROM Country c where c.name=:country",
                            Country.class).setParameter("country", countryName).getSingleResult();
                    product.setCountry(country);

                    List<Category> categoryList = entityManager.createQuery("SELECT category from Category category", Category.class).getResultList();
                    for (Category category:categoryList) {
                        System.out.print(category + " ");
                    }
                    System.out.println();
                    String categoryName = scann.readString("Choose category name");
                    Category category = entityManager.createQuery("SELECT category FROM Category category where category.categoryName=:category",
                            Category.class).setParameter("category", categoryName).getSingleResult();
                    product.setCategory(category);
                    PRODUCT_DAO.save(product);
                    break;
                }

                default:{
                    isRun = false;
                }
            }
        }
    }
}
