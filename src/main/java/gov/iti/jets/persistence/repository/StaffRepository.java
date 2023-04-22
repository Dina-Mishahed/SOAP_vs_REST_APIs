package gov.iti.jets.persistence.repository;

import gov.iti.jets.persistence.dao.StaffDao;
import gov.iti.jets.persistence.daoImp.StaffDaoImp;
import gov.iti.jets.service.dto.StaffDto;

import java.util.List;

public class StaffRepository implements StaffDao {
    StaffDao staffDao;
    public StaffRepository() {
        staffDao = new StaffDaoImp();
    }

    @Override
    public StaffDto getStaffById(Short id) {
        return staffDao.getStaffById(id);
    }

    @Override
    public List<StaffDto> getAllStaff() {
        return staffDao.getAllStaff();
    }

    @Override
    public boolean addStaff(StaffDto staffDto) {
        return staffDao.addStaff(staffDto);
    }

    @Override
    public boolean editStaff(Short staffId, StaffDto staffDto) {
        return staffDao.editStaff(staffId,staffDto);
    }

    @Override
    public Boolean deleteStaff(int id) {
        return staffDao.deleteStaff(id);
    }
}
