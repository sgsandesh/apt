package com.mySociety.services.basic;

import com.mySociety.model.orm.basic.SocietyEntity;
import com.mySociety.model.orm.basic.SocietyResidenceEntity;
import com.mySociety.model.view.basic.SocietyResidenceView;
import com.mySociety.repository.basic.SocietyResidenceRepository;
import com.mySociety.repository.basic.SocietyRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by sandesh on 10/9/17.
 */
@Component
public class SocietyResidenceService {

    private final SocietyRepository societyRepository;
    private final SocietyResidenceRepository societyResidenceRepository;


    public SocietyResidenceService(SocietyRepository societyRepository, SocietyResidenceRepository societyResidenceRepository) {
        this.societyRepository = societyRepository;
        this.societyResidenceRepository = societyResidenceRepository;
    }


    public Set<SocietyResidenceEntity> fetchResidences(Integer societyId) {
       return societyResidenceRepository.findBySociety(societyRepository.findBySocietyId(societyId));
    }


    @Transactional
    public void add(final SocietyResidenceView societyResidenceView) throws Exception {
        final String blockNumber = societyResidenceView.getBlockNumber();
        final String residenceNumber = societyResidenceView.getResidenceNumber();
        final SocietyEntity society = fetchSocietyEntity(societyResidenceView.getSocietyId());
        SocietyResidenceEntity societyResidenceEntity = new SocietyResidenceEntity();
        validateIfResidenceDoesNotExistInSociety( society, blockNumber, residenceNumber);
        societyResidenceEntity.setSociety(society);
        societyResidenceEntity.setBlockNumber(societyResidenceView.getBlockNumber());
        societyResidenceEntity.setResidenceNumber(societyResidenceView.getResidenceNumber());
        societyResidenceEntity.setIntercom(societyResidenceView.getIntercom());
        societyResidenceRepository.save(societyResidenceEntity);
    }


    @Transactional
    public void remove(final SocietyResidenceView societyResidenceView) throws Exception {
        final SocietyEntity society = fetchSocietyEntity(societyResidenceView.getSocietyId());

        final SocietyResidenceEntity existingEntity = validateIfResidenceExistInSociety(society,
                societyResidenceView.getBlockNumber(), societyResidenceView.getResidenceNumber());
        societyResidenceRepository.delete(existingEntity);
    }


    @Transactional
    public void updateIntercom(final SocietyResidenceView societyResidenceView) throws Exception {
        final SocietyEntity society = fetchSocietyEntity(societyResidenceView.getSocietyId());

        final SocietyResidenceEntity existingEntity = validateIfResidenceExistInSociety(society,
                societyResidenceView.getBlockNumber(), societyResidenceView.getResidenceNumber());
        existingEntity.setIntercom(societyResidenceView.getIntercom());
    }


    private void validateIfResidenceDoesNotExistInSociety(final SocietyEntity society, final String blockNumber, final String residenceNumber) throws Exception {
        final SocietyResidenceEntity existingSocietyResidenceEntity = societyResidenceRepository.
                findBySocietyAndBlockNumberAndResidenceNumber(society,blockNumber,residenceNumber);

        if(existingSocietyResidenceEntity != null){
            if(blockNumber == null){
                throw new Exception(String.format("residence#%s in %s society already exists",
                        residenceNumber, society.getSocietyName()));
            }else{
                throw new Exception(String.format("block#%s residence#%s in %s society already exists",
                        blockNumber, residenceNumber, society.getSocietyName()));
            }
        }
    }

    public SocietyResidenceEntity validateIfResidenceExistInSociety( final SocietyEntity society, final String blockNumber, final String residenceNumber) throws Exception {
        final SocietyResidenceEntity existingSocietyResidenceEntity = societyResidenceRepository.
                findBySocietyAndBlockNumberAndResidenceNumber(society,blockNumber,residenceNumber);

        if(existingSocietyResidenceEntity == null){
            if(blockNumber == null){
                throw new Exception(String.format("residence#%s in %s society doesnot exist",
                        residenceNumber, society.getSocietyName()));
            }else{
                throw new Exception(String.format("block#%s residence#%s in %s society doesnot exist",
                        blockNumber, residenceNumber, society.getSocietyName()));
            }
        }

        return existingSocietyResidenceEntity;
    }


    private SocietyEntity fetchSocietyEntity(Integer societyId) throws Exception {
        final SocietyEntity society = societyRepository.findBySocietyId(societyId);

        if (society == null){
            throw new Exception("society not found!!");
        }
        return society;
    }

}
