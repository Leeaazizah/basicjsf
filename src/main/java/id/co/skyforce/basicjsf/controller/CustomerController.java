package id.co.skyforce.basicjsf.controller;

import id.co.skyforce.basicjsf.HibernateUtil;
import id.co.skyforce.basicjsf.domain.Address;
import id.co.skyforce.basicjsf.domain.Customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean
public class CustomerController{
	
	private String salutation;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private Character gender;
	private String homePhone;
	private String mobilePhone;
	private String email;
	private String password;
	private String street;
	private String city;
	private String postalCode;
	private String message;
	private Long customerId;
	private Long addressId;
	
	public CustomerController(){
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		
		if (id != null){
			Long customerId = Long.valueOf(id);
			
			Session session = HibernateUtil.openSession();
			Transaction trx = session.beginTransaction();
			
			Customer customer = (Customer) session.get(Customer.class, customerId);
			Address address = new Address();
			
			this.customerId = customer.getId();
			salutation = customer.getSalutation();
			firstName = customer.getFirstName();
			lastName = customer.getLastName();
			birthDate = customer.getBirthDate();
			gender = customer.getGender();
			homePhone = customer.getHomePhone();
			mobilePhone = customer.getMobileNo();
			email = customer.getEmail();
			password = customer.getPassword();
			
			addressId = customer.getAddress().getId();
			street = customer.getAddress().getStreet();
			city = customer.getAddress().getCity();
			postalCode = customer.getAddress().getPostalCode();
			
			trx.commit();
			session.close();
		}

	}
	
public String save(){
		
		Customer customer = new Customer();
		Address address = new Address();
		
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		
		customer.setId(this.customerId);
		customer.setBirthDate(this.birthDate);
		customer.setEmail(this.email);
		customer.setFirstName(this.firstName);
		customer.setLastName(this.lastName);
		customer.setHomePhone(this.homePhone);
		customer.setMobileNo(this.mobilePhone);
		customer.setPassword(this.password);
		customer.setGender(this.gender);
		customer.setSalutation(this.salutation);
		
	
		address.setId(this.addressId);
		address.setCity(this.city);
		address.setPostalCode(this.postalCode);
		address.setStreet(this.street);
		
		customer.setAddress(address);


		session.saveOrUpdate(customer);
		trx.commit();
		session.close();
		
		this.message = "Customer Successfully Saved";
		return "list";
		
	}
	
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getSalutation() {
		return salutation;
	}
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}
	
	public Character getGender() {
		return gender;
	}
	public void setGender(Character gender) {
		this.gender = gender;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	
	
	
	

}
