package gov.iti.jets.persistence.dao;

import gov.iti.jets.service.dto.StaffDto;

import java.util.List;

public interface StaffDao {
    public StaffDto getStaffById(Short id);
    public List<StaffDto> getAllStaff();
    public boolean addStaff(StaffDto staffDto);
    public boolean editStaff(Short staffId, StaffDto staffDto);
    public Boolean deleteStaff(int id);
}


