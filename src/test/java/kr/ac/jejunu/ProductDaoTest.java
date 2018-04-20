package kr.ac.jejunu;

import com.sun.scenario.effect.impl.prism.PrDrawable;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class ProductDaoTest {
    ProductDao productDao;
    ProductDao hallaProductDao;
    @Before
    public void setup() {
        productDao = new JejuProductDao();
        hallaProductDao = new HallaProductDao();
    }

    @Test
    public void get() throws SQLException, ClassNotFoundException {
        Long id = 1L;
        String title = "제주감귤";
        Integer price = 15000;

        Product product = productDao.get(id);
        assertEquals(id, product.getId());
        assertEquals(title, product.getTitle());
        assertEquals(price, product.getPrice());
    }
    @Test
    public void add() throws SQLException, ClassNotFoundException {
        Product product = new Product();
        product.setTitle("딸기");
        product.setPrice(8000);

        Long id = productDao.insert(product);
        Product addProduct = productDao.get(id);

        assertEquals(addProduct.getId(), id);
        assertEquals(addProduct.getTitle(), product.getTitle());
        assertEquals(addProduct.getPrice(), product.getPrice());
    }
    @Test
    public void hallaget() throws SQLException, ClassNotFoundException {
        Long id = 1L;
        String title = "제주감귤";
        Integer price = 15000;

        Product product = productDao.get(id);
        assertEquals(id, product.getId());
        assertEquals(title, product.getTitle());
        assertEquals(price, product.getPrice());
    }
}
