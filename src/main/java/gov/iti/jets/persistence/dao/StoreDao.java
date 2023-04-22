package gov.iti.jets.persistence.dao;

import gov.iti.jets.service.dto.*;

import java.util.List;

public interface StoreDao {
    StoreDto getStoreById(Short id);
    void addStore(int managerStaffId,int addressId);
    Boolean editStore(StoreDto storeDto);
    List<InventoryDto> getInventoryListByStore(int id);
    StaffDto getManagerStaff(int storeId);

    List<CustomerDto> getCustomerListByStore(int id);

    List<StoreDto> getAllStores();
    public Boolean deleteStore(int id);

}
