package com.aptmnt.recources;

import com.aptmnt.model.basic.Apartment;
import com.aptmnt.model.basic.User;
import com.aptmnt.services.basic.ApartmentService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sandesh on 10/9/17.
 */
@RestController
@RequestMapping("/rest/apartment")
public class ApartmentResource {
    private final ApartmentService apartmentService;

    public ApartmentResource(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    @RequestMapping(method = RequestMethod.GET)
    List<Apartment> getApartments(){
        return apartmentService.getAll();
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public Apartment createApartment(@RequestBody Apartment apartment) throws Exception {
        return apartmentService.create(apartment);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Apartment updateApartment(@RequestBody Apartment apartment) throws Exception {
        return apartmentService.update(apartment);
    }
}
