package gov.iti.jets.persistence.daoImp;

import gov.iti.jets.persistence.dao.RentalDao;
import gov.iti.jets.persistence.entity.Rental;
import gov.iti.jets.service.dto.RentalDto;
import gov.iti.jets.service.mapper.RentalMapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

public class RentalDaoImp extends BaseDAO implements RentalDao {
    private RentalMapper rentalMapper;

    public RentalDaoImp(){
        rentalMapper = Mappers.getMapper(RentalMapper.class);
    }
    @Override
    public RentalDto getRentalById(int id) {
        Rental rental = (Rental) get(Rental.class,"rentalId",id);
        return rentalMapper.toDto(rental);
    }

    @Override
    public List<RentalDto> getAllRental() {
        List<Rental> rentalList = getAll(Rental.class);
        List<RentalDto> rentalDtoList = rentalList.stream().map((rental -> rentalMapper.toDto(rental))).toList();
        return rentalDtoList;
    }
}
