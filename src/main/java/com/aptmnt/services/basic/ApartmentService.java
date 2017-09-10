package com.aptmnt.services.basic;

import com.aptmnt.model.basic.Apartment;
import com.aptmnt.model.basic.User;
import com.aptmnt.repository.basic.ApartmentRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by sandesh on 10/9/17.
 */
@Component
public class ApartmentService {

    private final ApartmentRepository apartmentRepository;

    public ApartmentService(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    public List<Apartment> getAll() {
        return apartmentRepository.findAll();
    }

    @Transactional
    public Apartment create(Apartment apartment) throws Exception {
        if(apartmentRepository.findByAptName(apartment.getAptName()) != null){
            throw new Exception("Apartment name already exists");
        }
        apartment.setCreatedUser("LOGGED-IN-USER-ID");
        apartment.setCreatedTimestamp(new Date());
        addAuditDetails(apartment, "LOGGED-IN-USER-ID", 'Y');
        return apartmentRepository.save(apartment);
    }

    @Transactional
    public Apartment update(Apartment apartment) throws Exception {
        Apartment existingEntity = apartmentRepository.findByAptId(apartment.getAptId());
        if(existingEntity == null){
            throw new Exception("Apartment does not exist");
        }
        existingEntity.setAptName(apartment.getAptName());
        existingEntity.setCity(apartment.getCity());
        addAuditDetails(existingEntity, "LOGGED-IN-USER-ID", 'Y');
        return existingEntity;
    }

    private void addAuditDetails(final Apartment apartmentEntity, final String userName, final char isActive) {
        apartmentEntity.setUpdatedUser(userName);
        apartmentEntity.setUpdatedTimestamp(new Date());
        apartmentEntity.setActive(isActive);
    }
}
