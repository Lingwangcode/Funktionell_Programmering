package Inlämning1_webbshop;

import java.util.List;

public interface RepositoryInterface {

    Customer getCustomer(String name, String password);

    List<Product> getAllProductToList();
    List<Size> getAllSize();

}
