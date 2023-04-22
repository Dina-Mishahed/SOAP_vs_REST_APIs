package gov.iti.jets.persistence.daoImp;

import gov.iti.jets.persistence.dao.StaffDao;
import gov.iti.jets.persistence.entity.Staff;
import gov.iti.jets.persistence.util.HibernateEntityManagerFactory;
import gov.iti.jets.service.dto.StaffDto;
import gov.iti.jets.service.mapper.StaffMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.Root;
import org.mapstruct.factory.Mappers;

import java.util.Date;
import java.util.List;

public class StaffDaoImp extends BaseDAO implements StaffDao  {
    StaffMapper staffMapper;
    public StaffDaoImp(){
        staffMapper = Mappers.getMapper(StaffMapper.class);
    }
    @Override
    public StaffDto getStaffById(Short id) {
        Staff staff = (Staff) get(Staff.class,"staffId",id);
        return staffMapper.toDto(staff);
    }

    @Override
    public List<StaffDto> getAllStaff() {
        List<Staff> staffList = getAll(Staff.class);
        return staffList.stream().map((staff -> staffMapper.toDto(staff))).toList();
    }

    @Override
    public boolean addStaff(StaffDto staffDto) {
        staffDto.setLastUpdate(new Date());
        EntityManager entityManager = null;
        try {
            entityManager = HibernateEntityManagerFactory.getEntityManagerFactory().createEntityManager();
            Staff staff = staffMapper.toEntity(staffDto);
            entityManager.getTransaction().begin();
            entityManager.persist(staff);
            entityManager.getTransaction().commit();
            HibernateEntityManagerFactory.getEntityManagerFactory();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }finally{
            entityManager.close();
        }
        return true;
    }

    @Override
    public boolean editStaff(Short staffId, StaffDto staffDto) {
        staffDto.setStaffId(staffId);
        staffDto.setLastUpdate(new Date());
        EntityManager entityManager = null;
        try {
            entityManager = HibernateEntityManagerFactory.getEntityManagerFactory().createEntityManager();

            Staff staff = staffMapper.toEntity(staffDto);
            entityManager.getTransaction().begin();
            entityManager.merge(staff);
            entityManager.getTransaction().commit();
            HibernateEntityManagerFactory.getEntityManagerFactory();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }finally{
            entityManager.close();
        }
        return true;
    }
    @Override
    public Boolean deleteStaff(int id) {
        EntityManager entityManager = null;
        try {
            entityManager = HibernateEntityManagerFactory.getEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaDelete<Staff> cd = cb.createCriteriaDelete(Staff.class);
            Root<Staff> root = cd.from(Staff.class);
            cd.where(cb.equal(root.get("staffId"), id));
            entityManager.createQuery(cd).executeUpdate();
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }finally{
            entityManager.close();
        }
    }
}
