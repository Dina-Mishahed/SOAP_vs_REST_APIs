//package gov.iti.jets.service.mapper;
//
//import gov.iti.jets.service.dto.CustomerDto;
//import gov.iti.jets.persistence.entity.Customer;
//import org.mapstruct.*;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
//import static java.util.stream.Collectors.toCollection;
//
//@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel ="cdi")
//public interface CustomerMapper {
//    Customer toEntity(CustomerDto customerDto);
//
//    CustomerDto toDto(Customer customer);
//
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    Customer partialUpdate(CustomerDto customerDto, @MappingTarget Customer customer);
//
//    default ArrayList<CustomerDto> toDTOs(Collection<Customer> customers) {
//        return customers.stream().map(entity -> toDto(entity)).collect(toCollection(ArrayList<CustomerDto>::new));
//    }
//
//    default ArrayList<Customer> toEntities(Collection<CustomerDto> customerDtoS) {
//        return customerDtoS.stream().map(dto -> toEntity(dto)).collect(toCollection(ArrayList<Customer>::new));
//    }
//}