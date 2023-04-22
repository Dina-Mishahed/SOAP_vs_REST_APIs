package gov.iti.jets.persistence.daoImp;

import gov.iti.jets.persistence.dao.InventoryDao;
import gov.iti.jets.persistence.entity.Inventory;
import gov.iti.jets.service.dto.InventoryDto;
import gov.iti.jets.service.mapper.InventoryMapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

public class InventoryDaoImp extends BaseDAO implements InventoryDao {
    private InventoryMapper inventoryMapper;

    public InventoryDaoImp(){
        inventoryMapper = Mappers.getMapper(InventoryMapper.class);
    }
    @Override
    public InventoryDto getInventoryDById(int id) {
        Inventory inventory = (Inventory) get(Inventory.class,"inventoryId",id);
        return inventoryMapper.toDto(inventory);
    }

    @Override
    public List<InventoryDto> getAllInventoryD() {
        List<Inventory> inventoryList = getAll(Inventory.class);
        List<InventoryDto> inventoryDtoList = inventoryList.stream().map((inventory -> inventoryMapper.toDto(inventory))).toList();
        return inventoryDtoList;
    }
}
