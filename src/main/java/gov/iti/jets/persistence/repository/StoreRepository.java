package gov.iti.jets.persistence.repository;

import gov.iti.jets.persistence.dao.StoreDao;
import gov.iti.jets.persistence.daoImp.StoreDaoImp;
import gov.iti.jets.service.dto.CustomerDto;
import gov.iti.jets.service.dto.InventoryDto;
import gov.iti.jets.service.dto.StaffDto;
import gov.iti.jets.service.dto.StoreDto;

import java.util.List;

public class  StoreRepository implements StoreDao {
    private StoreDao storeDao;
    public StoreRepository() {
        storeDao = new StoreDaoImp();
    }

    @Override
    public StoreDto getStoreById(Short id) {
        return storeDao.getStoreById(id);
    }

    @Override
    public void addStore(int managerStaffId, int addressId) {
        storeDao.addStore(managerStaffId,addressId);
    }

    @Override
    public Boolean editStore(StoreDto storeDto) {
        return storeDao.editStore(storeDto);
    }

    @Override
    public List<InventoryDto> getInventoryListByStore(int id) {
        return storeDao.getInventoryListByStore(id);
    }

    @Override
    public StaffDto getManagerStaff(int storeId) {
        return storeDao.getManagerStaff(storeId);
    }

    @Override
    public List<CustomerDto> getCustomerListByStore(int id) {
        return storeDao.getCustomerListByStore(id);
    }

    @Override
    public List<StoreDto> getAllStores() {
        return storeDao.getAllStores();
    }

    @Override
    public Boolean deleteStore(int id) {
        return storeDao.deleteStore(id);
    }
}
