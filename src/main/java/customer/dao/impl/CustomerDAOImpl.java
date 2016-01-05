package customer.dao.impl;

import customer.dao.CustomerDAO;
import customer.model.Customer;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hsenid on 1/5/16.
 */
public class CustomerDAOImpl implements CustomerDAO {

    private DataSource dataSource;
   // private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
       // this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }


    public void insert(Customer customer) {

        String sql = "INSERT INTO customer (CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, customer.getCustId());
            ps.setString(2, customer.getName());
            ps.setInt(3, customer.getAge());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }

        System.out.println("Created Record Name = " + customer.getName() + " Age = " + customer.getAge());

    }

    public Customer findByCustomerId(int custId){
        String sql = "SELECT * FROM customer WHERE CUST_ID = ?";
        Connection conn = null;

        try{
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, custId);
            Customer customer = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                customer = new Customer(rs.getInt("CUST_ID"), rs.getString("NAME"), rs.getInt("Age"));
            }
            rs.close();
            ps.close();
            return customer;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
        return null;
    }

    public List<Customer> findCustomerByAge(int age){

        String sql="Select   *from customer WHERE Age=?";
        Connection conn=null;
        List<Customer> customerList=new ArrayList<Customer>();
        try{
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, age);
            Customer customer = null;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                customer = new Customer(rs.getInt("CUST_ID"), rs.getString("NAME"), rs.getInt("Age"));
                customerList.add(customer);
            }
            rs.close();
            ps.close();
            return customerList;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
        return null;
    }

    public void update(Customer customer){

        String sql = "UPDATE customer set NAME=?, AGE=? WHERE CUST_ID=?";
        Connection conn=null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, customer.getName());
            ps.setInt(2, customer.getAge());
            ps.setInt(3, customer.getCustId());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }


    }

    public void deleteById(int id){

        String sql="delete from customer where CUST_ID=?";
        Connection conn= null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }

    }
}
