package kr.ac.jejunu;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class ProductDaoTest {
    ProductDao productDao;
    private DaoFactory daoFactory;

    @Before
    public void setup() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DaoFactory.class);
        productDao = applicationContext.getBean(ProductDao.class);
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
    public void update() throws SQLException, ClassNotFoundException {
        Product product = new Product();
        product.setTitle("딸기");
        product.setPrice(8000);
        Long id = productDao.insert(product);

        product.setId(id);
        product.setTitle("포도");
        product.setPrice(5000);

        productDao.update(product);
        Product updateProduct = productDao.get(id);

        assertEquals(updateProduct.getId(), id);
        assertEquals(updateProduct.getTitle(), product.getTitle());
        assertEquals(updateProduct.getPrice(), product.getPrice());
    }
    @Test
    public void delete() throws SQLException {
        Product product = new Product();
        product.setTitle("딸기");
        product.setPrice(8000);
        Long id = productDao.insert(product);

        productDao.delete(id);
        Product deleteProduct = productDao.get(id);

        assertEquals(deleteProduct, null);
    }

}
