package com.mkyong.customer.bo;

/**
 * Created by cesardiaz on 23/07/15.
 */
public interface CustomerBo {

    void addCustomer();

    String addCustomerReturnValue();

    void addCustomerThrowException() throws Exception;

    void addCustomerAround(String name);

}
