package fcu.sep.fcushop.service;

import fcu.sep.fcushop.database.Sql2oDbHandler;
import fcu.sep.fcushop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;

import java.util.List;

@Service
public class ShoppingCart {

    @Autowired
    private Sql2oDbHandler sql2oDbHandler;

    public ShoppingCart() {

    }

    public List<Product> getProducts() {
        try (Connection connection = sql2oDbHandler.getConnector().open()) {
            String query = "select ID id, NAME name, IMAGE_URL imageUrl, PRICE price, DESCRIPTION description"
                    + " from product";

            return connection.createQuery(query).executeAndFetch(Product.class);
        }
    }

    public List<Product> getProducts(String keyword) {
        try (Connection connection = sql2oDbHandler.getConnector().open()) {
            String query = "select ID id, NAME name, IMAGE_URL imageUrl, PRICE price, DESCRIPTION description"
                    + " from product where name like :keyword";

            return connection.createQuery(query)
                    .addParameter("keyword", "%"+keyword+"%")
                    .executeAndFetch(Product.class);
        }
    }
}
