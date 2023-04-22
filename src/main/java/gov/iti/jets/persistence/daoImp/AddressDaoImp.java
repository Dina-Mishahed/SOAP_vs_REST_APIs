package gov.iti.jets.persistence.daoImp;

import gov.iti.jets.persistence.dao.AddressDao;
import gov.iti.jets.persistence.entity.Address;
import gov.iti.jets.persistence.util.HibernateEntityManagerFactory;
import gov.iti.jets.service.dto.AddressDto;
import gov.iti.jets.service.mapper.AddressMapper;
import jakarta.persistence.EntityManager;
import org.mapstruct.factory.Mappers;
import java.util.Date;
import java.util.List;

public class AddressDaoImp extends BaseDAO implements AddressDao {
    AddressMapper addressMapper;
    public AddressDaoImp(){
        addressMapper = Mappers.getMapper(AddressMapper.class);
    }
    @Override
    public AddressDto geAddressById(Short id) {
        Address address = (Address) get(Address.class,"addressId",id);
        return addressMapper.toDto(address);
    }

    @Override
    public List<AddressDto> getAllAddress() {
        List<Address> addressList = getAll(Address.class);
        return addressList.stream().map((address -> addressMapper.toDto(address))).toList();
    }

    @Override
    public Boolean updateAddress(AddressDto addressDto) {
        EntityManager entityManager = null;
        try {
            entityManager = HibernateEntityManagerFactory.getEntityManagerFactory().createEntityManager();
            if(addressDto.getLastUpdate() == null){
                addressDto.setLastUpdate(new Date());
            }
            Address address = addressMapper.toEntity(addressDto) ;
            entityManager.getTransaction().begin();
            entityManager.merge(address);
            entityManager.getTransaction().commit();
            HibernateEntityManagerFactory.getEntityManagerFactory();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }finally{
            entityManager.close();
        }
        return true;
    }

    @Override
    public Boolean addAddress(AddressDto addressDto) {
        EntityManager entityManager = null;
        try {
            entityManager = HibernateEntityManagerFactory.getEntityManagerFactory().createEntityManager();
            if(addressDto.getLastUpdate() == null){
                addressDto.setLastUpdate(new Date());
            }
            Address address = addressMapper.toEntity(addressDto) ;
            entityManager.getTransaction().begin();
            entityManager.persist(address);
            entityManager.getTransaction().commit();
            HibernateEntityManagerFactory.getEntityManagerFactory();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }finally{
            entityManager.close();
        }
        return true;
    }

    @Override
    public AddressDto getAddresByPostalCode(String postalCode) {
        try{
            int p = Integer.parseInt(postalCode);
            Address address = (Address) get(Address.class,"postalCode",p);
            return addressMapper.toDto(address);
        }catch(Exception e){
            throw new NumberFormatException("incorrect postalCode");
        }

//        return executeWithEntityManager((EntityManager)entityManager -> {
//            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//            CriteriaQuery<Address> cq = cb.createQuery(Address.class);
//            Root<Address> root = cq.from(Address.class);
//            cq.where(cb.equal(root.get(postalCode), postalCode));
//            TypedQuery<Address> query = entityManager.createQuery(cq);
//            return addressMapper.toDto(query.getSingleResult());
//        });
    }
}
