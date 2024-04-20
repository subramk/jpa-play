package com.jpa.play.persistence.repository;

import com.jpa.play.persistence.domain.Address;
import com.jpa.play.persistence.domain.Customer;
import com.jpa.play.persistence.domain.MyCourses;
import com.jpa.play.persistence.domain.MyCoursesDetails;
import jakarta.transaction.Transactional;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;

import java.util.Collections;
import java.util.List;

import static java.util.List.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/*
*********************************************************************************
        Customer has a ONE-TO-MANY relationship with Address


*********************************************************************************
*/

@DataJpaTest
public class CustomerAddressOneToManyRepositoryTest extends  AbstractBaseTestContainer {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository ;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    @DisplayName("Navigate from Customer to Address")
    public void saveCustomerWithAddresses() {

        Customer customer = Customer.builder().name("kasi").email("kasi@gmail.com").gender("M").build();


        Address address1 = Address.builder().line1("line1").line2("line1").postCode("SM12JE").customer(customer).build();
        Address address2 = Address.builder().line1("line2").line2("line2").postCode("SM12SX").customer(customer).build();

        List<Address> addressList = of(address1, address2);

        customer.setAddresses(addressList);

        Customer savedCustomer = customerRepository.saveAndFlush(customer);


        Assert.assertNotNull(savedCustomer.getId());
        // customer should have 2 addresses
        Assert.assertThat(2, is(savedCustomer.getAddresses().size()));

    }

    @Test
    @DisplayName("Pull out Address from Customer")
    public void getCustomerFromAddressEntity() {

        Customer customer = Customer.builder().name("kasi").email("kasi@gmail.com").gender("M").build();

        Address address1 = Address.builder().line1("line1").line2("line1").postCode("SM12JE").customer(customer).build();
        Address address2 = Address.builder().line1("line2").line2("line2").postCode("SM12SX").customer(customer).build();

        List<Address> addressList = of(address1,address2);
        customer.setAddresses(addressList);

        Customer savedCustomer = customerRepository.saveAndFlush(customer);

        Long customerId_forFirstAddress = savedCustomer.getAddresses().get(0).getCustomer().getId();
        Long customerId_forSecondAddress  = savedCustomer.getAddresses().get(1).getCustomer().getId();

        Assert.assertThat(customerId_forFirstAddress, equalTo(customerId_forSecondAddress ));

    }


    @Test
    @DisplayName("Delete Customer Should Cascade To Addresss")
    @Sql("classpath:/scripts/INIT_CUSTOMER_WITH_ADDRESS.sql")
    @Transactional  // NEEDED , even if @DataJpaTest has the @Transactional - why ?
    public void deleteCustomerShouldCascadeDeleteAddresses() {

        Customer customer  = customerRepository.findById(100L).get();
        customerRepository.delete(customer);
        customerRepository.flush();

        String query1   = "select count(*) as count from customer";
        int  rows1 = jdbcTemplate.queryForObject(query1,Integer.class);
        assertEquals( rows1, 3) ;

        String addressCount   = "select count(*) as count from address";
        int  rows2 = jdbcTemplate.queryForObject(addressCount,Integer.class);
        assertEquals( rows2, 3) ;

        List<Customer> latest  = customerRepository.findAll();
        Assert.assertTrue( latest.size() == 3 );

        //TODO better way to iterate and assert using AssertJ ??
        latest.stream().allMatch( cust ->
            cust.getName().equals("Anez") ||
            cust.getName().equals("Satish") ||
            cust.getName().equals("DrJohn") );
    }

    @Test
    @DisplayName("N+1 Issue Present on Loading Customer with 50 Addresses")
    @Sql("classpath:/scripts/INIT_CUSTOMER_WITH_50_ADDRESSES.sql")
    public void N_Plus_One_Issue_loadCustomerWith_50_Address() {
        List<Customer> customerList  = customerRepository.findAll();
        assertEquals(customerList.size() ,  1);
        assertEquals(customerList.getFirst().getAddresses().size() ,  50);

        for(Customer customer : customerList )  {
            // GET ALL THE ADDRESSES FOR THE CUSTOMER
            customer.getAddresses()
                    .forEach( addr -> System.out.println(" Address ID "+  addr.getAddressId() +  " ||  " + addr.getLine1() ));
        }
    }

    @Test
    @DisplayName(" Join Fetch solves N+1 Problem")
    @Sql("classpath:/scripts/INIT_CUSTOMER_WITH_50_ADDRESSES.sql")
    public void usingJoinFetch() {
        List<Customer> customerList  = customerRepository.retrieveAllCustomersWithAddress();
        assertEquals(customerList.size() ,  1);
        assertEquals(customerList.getFirst().getAddresses().size() ,  50);

        for(Customer customer : customerList )  {
            // GET ALL THE ADDRESSES FOR THE CUSTOMER

            customer.getAddresses()
                    .forEach( addr -> System.out.println(" Address ID "+  addr.getAddressId() +  " ||  " + addr.getLine1() ));
        }
    }


//

}
