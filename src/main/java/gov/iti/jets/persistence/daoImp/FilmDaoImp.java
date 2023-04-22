package gov.iti.jets.persistence.daoImp;

import java.util.Date;
import java.util.List;

import gov.iti.jets.persistence.dao.FilmDao;
import gov.iti.jets.persistence.entity.Film;
import gov.iti.jets.persistence.util.HibernateEntityManagerFactory;
import gov.iti.jets.service.dto.FilmDto;
import gov.iti.jets.service.mapper.FilmMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.Root;
import org.mapstruct.factory.Mappers;

public class FilmDaoImp  extends BaseDAO implements FilmDao{
    private FilmMapper filmMapper;
    public FilmDaoImp(){
        filmMapper = Mappers.getMapper(FilmMapper.class);
    }
    @Override
    public Boolean createFilm(FilmDto filmDto) {
        EntityManager entityManager = null;
        try {
            entityManager = HibernateEntityManagerFactory.getEntityManagerFactory().createEntityManager();
            if(filmDto.getLastUpdate() == null ){
                filmDto.setLastUpdate(new Date());
            }
            Film film = filmMapper.toEntity(filmDto);
            entityManager.getTransaction().begin();
            entityManager.persist(film);
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
    public FilmDto getFilmById(int id) {
        Film film = (Film) get(Film.class,"filmId",id);
        return filmMapper.toDto(film);
    }

    @Override
    public Boolean updateFilm(FilmDto filmDto) {
        EntityManager entityManager = null;

        try {
            entityManager = HibernateEntityManagerFactory.getEntityManagerFactory().createEntityManager();
            Film film = filmMapper.toEntity(filmDto);
            entityManager.getTransaction().begin();
            entityManager.merge(film);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }finally{
            entityManager.close();
        }
    }

    @Override
    public Boolean deleteFilm(int id) {
        EntityManager entityManager = null;
        try {
            entityManager = HibernateEntityManagerFactory.getEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaDelete<Film> cd = cb.createCriteriaDelete(Film.class);
            Root<Film> root = cd.from(Film.class);
            cd.where(cb.equal(root.get("filmId"), id));
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

    @Override
    public List<FilmDto> getAllFilms() {
        List<Film> filmList = getAll(Film.class);
        return filmList.stream().map((film -> filmMapper.toDto(film))).toList();
    }
}
