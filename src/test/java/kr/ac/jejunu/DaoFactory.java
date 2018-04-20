package kr.ac.jejunu;

public class DaoFactory {
    private ProductDao productDao;

    public ProductDao getProductDao() {
        return new ProductDao(getConnectionMaker());
    }

    private JejuConnectionMaker getConnectionMaker() {
        return new JejuConnectionMaker();
    }
}
