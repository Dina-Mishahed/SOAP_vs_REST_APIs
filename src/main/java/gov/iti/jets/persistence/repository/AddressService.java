package gov.iti.jets.persistence.repository;

import gov.iti.jets.persistence.dao.AddressDao;
import gov.iti.jets.persistence.daoImp.AddressDaoImp;
import gov.iti.jets.service.dto.AddressDto;

import java.util.List;

public class AddressService implements AddressDao {
    private AddressDao addressDao;
    public AddressService(){
        addressDao = new AddressDaoImp();
    }
    @Override
    public AddressDto geAddressById(Short id) {
        return addressDao.geAddressById(id);
    }

    @Override
    public List<AddressDto> getAllAddress() {
        return addressDao.getAllAddress();
    }

    @Override
    public Boolean updateAddress(AddressDto addressDto) {
        return null;
    }

    @Override
    public Boolean addAddress(AddressDto addressDto) {
        return null;
    }

    @Override
    public AddressDto getAddresByPostalCode(String postalCode) {
        return null;
    }
}
