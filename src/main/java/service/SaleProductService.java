package service;

import models.CustomerBasket;
import repository.SaleProductRepository;

import java.sql.SQLException;
import java.util.List;

public class SaleProductService {
    SaleProductRepository saleProductRepository =new SaleProductRepository();

    public SaleProductService() throws SQLException, ClassNotFoundException {
    }

    public void add(List<CustomerBasket> list) throws SQLException {
        saleProductRepository.add(list);

    }


}
