package gov.iti.jets.persistence.daoImp;

import gov.iti.jets.persistence.dao.LanguageDao;
import gov.iti.jets.persistence.entity.Language;
import gov.iti.jets.service.dto.LanguageDto;
import gov.iti.jets.service.mapper.LanguageMapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

public class LanguageDaoImp extends BaseDAO implements LanguageDao {
    private LanguageMapper languageMapper;

    public LanguageDaoImp(){
        languageMapper = Mappers.getMapper(LanguageMapper.class);
    }
    @Override
    public LanguageDto getLanguageById(int id) {
        Language language = (Language) get(Language.class,"languageId",id);
        return languageMapper.toDto(language);
    }

    @Override
    public List<LanguageDto> getAllLanguage() {
        List<Language> languageList = getAll(Language.class);
        List<LanguageDto> languageDtos = languageList.stream().map((language -> languageMapper.toDto(language))).toList();
        return languageDtos;
    }
}
