package gov.iti.jets.service.soap;

import gov.iti.jets.persistence.repository.CustomerRepository;
import gov.iti.jets.service.dto.CustomerDto;
import gov.iti.jets.service.dto.PaymentDto;
import gov.iti.jets.service.dto.RentalDto;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class CustomerService {
    private CustomerRepository customerRepository = new  CustomerRepository();

    @WebMethod(operationName = "FindgetCustomerById")
    public CustomerDto getCustomerById(@WebParam(name = "customerId") int id) {
        return customerRepository.getCustomerById(id);
    }
    @WebMethod(operationName = "GetAllCustomers")
    public List<CustomerDto> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }
    @WebMethod(operationName = "DeleteFilm")
    public Boolean addCustomer(@WebParam(name = "customerDto")CustomerDto customerDto) {
        return customerRepository.addCustomer(customerDto);
    }
    @WebMethod(operationName = "FindAllFilms")
    public List<CustomerDto> getCustomersByName(@WebParam(name = "customerName")String name){
        return customerRepository.getCustomersByName(name);
    }

    @WebMethod(operationName = "FindCustomerRentalById")
    public List<RentalDto> getCustomerRentalById(@WebParam(name = "customerId")int id){
        return customerRepository.getCustomerRentalById(id);
    }

    @WebMethod(operationName = "FindAllFilms")
    public List<PaymentDto> getCustomerPaymentById(@WebParam(name = "customerId")int id){
        return customerRepository.getCustomerPaymentById(id);
    }

    @WebMethod(operationName = "FindAllActiveCustomers")
    public List<CustomerDto> getAllActiveCustomers(){
        return customerRepository.getAllActiveCustomers();
    }

    @WebMethod(operationName = "FindAllInactiveCustomers")
    public List<CustomerDto> getAllInactiveCustomers() {
        return customerRepository.getAllInactiveCustomers();
    }
}
