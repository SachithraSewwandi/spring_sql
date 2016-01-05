package customer.test;

import customer.dao.CustomerDAO;
import customer.model.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by hsenid on 1/5/16.
 */

public class CustomerDaoTest {

    public  static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");

        //insert
        CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
        Customer customer = new Customer(1, "mkyong",28);
        Customer customer3 = new Customer(4, "mkyo",80);
        //customerDAO.insert(customer);
        /*customerDAO.insert(customer3);*/

        //query
        Customer customer1 = customerDAO.findByCustomerId(1);
       // System.out.println("Name :"+customer1.getName()+" Age :"+customer.getAge());

        List<Customer> customerList = customerDAO.findCustomerByAge(80);
        System.out.println(customerList.size());
        for(Customer cust :customerList){
            System.out.println("Name :"+cust.getName()+" Age :"+cust.getAge()+"  ID :"+cust.getCustId());
        }


        //update
        Customer customer2 = new Customer(1, "mkyong",45);
        customerDAO.update(customer2);

        //delete
        //customerDAO.deleteById(1);
    }

}