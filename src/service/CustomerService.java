package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import model.customer;

public class CustomerService {
//DB조회
	private Map<String, customer> customerMap;
	private static final CustomerService instance= new CustomerService();
	private CustomerService() {
		customerMap= new HashMap<String,customer>();
		
		addCustomer(new customer("id001","alice","alice.hansung.ac.kr"));	
		addCustomer(new customer("id002","bob","bob.hansung.ac.kr"));	
		addCustomer(new customer("id003","hi","hi.hansung.ac.kr"));	
		addCustomer(new customer("id004","bye","bye.hansung.ac.kr"));	
		addCustomer(new customer("id005","hello","hello.hansung.ac.kr"));	
		
	}
	public static CustomerService getInstance() {
		return instance;
	}//singleton
	private void addCustomer(customer customer) {
		// TODO Auto-generated method stub
		customerMap.put(customer.getId(), customer);
	}
	public customer findCustomer(String id) {
		if( id!=null)
		    return(customerMap.get(id.toLowerCase()));
		else 
			return null;
		
	}
	public List<customer> getAllCustomers(){
		List<customer> customerList= new ArrayList<customer>(customerMap.values());
		return customerList;
		
	}
}
