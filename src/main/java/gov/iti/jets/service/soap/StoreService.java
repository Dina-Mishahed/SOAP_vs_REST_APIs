package gov.iti.jets.service.soap;

import gov.iti.jets.persistence.repository.StoreRepository;
import gov.iti.jets.service.dto.CustomerDto;
import gov.iti.jets.service.dto.InventoryDto;
import gov.iti.jets.service.dto.StaffDto;
import gov.iti.jets.service.dto.StoreDto;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class StoreService {
    private StoreRepository storeRepository = new StoreRepository();

    @WebMethod(operationName = "FindStoreById")
    public StoreDto getStoreById(@WebParam(name = "storetId") short id){
        return storeRepository.getStoreById(id);
    }

    @WebMethod(operationName = "FindAllStore")
    public List<StoreDto> getAllStore() {
        return storeRepository.getAllStores();
    }


    @WebMethod(operationName = "AddStore")
    public void addStore(@WebParam(name = "managerStaffId")int managerStaffId,@WebParam(name = "addressId")int addressId){
         storeRepository.addStore(managerStaffId,addressId);
    }

    @WebMethod(operationName = "UpdateStore")
    Boolean editStore(@WebParam(name = "storeDto")StoreDto storeDto) {
        return storeRepository.editStore(storeDto);
    }
    @WebMethod(operationName = "FindInventoryListByStore")
    List<InventoryDto> getInventoryListByStore(@WebParam(name = "storetId") int id){
        return storeRepository.getInventoryListByStore(id);
    }

    @WebMethod(operationName = "FindManagerStaff")
    StaffDto getManagerStaff(@WebParam(name = "storetId")int storeId) {
        return storeRepository.getManagerStaff(storeId);
    }
    @WebMethod(operationName = "FindCustomerListByStore")
    List<CustomerDto> getCustomerListByStore(@WebParam(name = "storetId")int id){
        return storeRepository.getCustomerListByStore(id);
    }

    @WebMethod(operationName = "DeleteStore")
    public Boolean deleteStore(@WebParam(name = "storetId")int id) {
        return storeRepository.deleteStore(id);
    }
}
