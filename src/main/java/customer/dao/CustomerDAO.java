package customer.dao;

import customer.model.Customer;

/**
 * Created by hsenid on 1/5/16.
 */
public interface CustomerDAO {
    public void insert(Customer customer);
    public Customer findByCustomerId(int custId);
    public void update(Customer customer);
/*
    public void deleteById(int cusId);
*/
}
