package com.mkyong.core;

import com.mkyong.customer.bo.CustomerBo;
import com.mkyong.customer.services.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by cesardiaz on 23/07/15.
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext(
                new String[] { "Spring-Customer.xml" });

        CustomerService customerService = (CustomerService) appContext.getBean("customerService");

        System.out.println("*************************");
        customerService.printName();
        System.out.println("*************************");
        customerService.printURL();
        System.out.println("*************************");
        try {
            customerService.printThrowException();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        System.out.println("*************************");

        try {
            CustomerBo customer = (CustomerBo) appContext.getBean("customerBo");
            customer.addCustomer();
            customer.addCustomerReturnValue();
            customer.addCustomerThrowException();
            customer.addCustomerAround("mkyong");
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

}
