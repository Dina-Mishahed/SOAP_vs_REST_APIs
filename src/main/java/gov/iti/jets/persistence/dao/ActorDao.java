package gov.iti.jets.persistence.dao;

import java.util.List;

import gov.iti.jets.persistence.entity.Actor;
import gov.iti.jets.service.dto.ActorDto;
import gov.iti.jets.service.dto.FilmActorDto;

//searchActorByName
//getActorFilmList
// getActorFilmListByLanguage
//getActorFilmListByRating
// get count of actor film list
// get count of actor films by actor id and specific language
// get count of actor films by actor id and specific rating
public interface ActorDao {
    Boolean createActor(ActorDto actorDto);

    ActorDto getActorById(int id);

    Boolean updateActor(ActorDto actorDto);

    void deleteActor(int id);

    List<ActorDto> getAllActors();

    List<FilmActorDto> getFilmListByActor(int id);

    List<ActorDto> getActorByName(String name);
}
