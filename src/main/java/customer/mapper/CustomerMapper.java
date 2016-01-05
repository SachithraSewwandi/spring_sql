package customer.mapper;

import customer.model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hsenid on 1/5/16.
 */
public class CustomerMapper {
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setCustId(rs.getInt("id"));
        customer.setName(rs.getString("name"));
        customer.setAge(rs.getInt("age"));
        return customer;
    }
}
