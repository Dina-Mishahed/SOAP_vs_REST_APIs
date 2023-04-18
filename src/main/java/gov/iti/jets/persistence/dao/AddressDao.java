package gov.iti.jets.persistence.dao;

import gov.iti.jets.service.dto.AddressDto;
import gov.iti.jets.service.dto.StaffDto;

import java.util.List;

public interface AddressDao {
    public AddressDto geAddressById(Short id);
    public List<AddressDto> getAllAddress();
}
