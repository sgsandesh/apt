package com.mySociety.resources;

import com.mySociety.model.orm.basic.SocietyEntity;
import com.mySociety.services.basic.SocietyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sandesh on 10/9/17.
 */
@RestController
@RequestMapping("/rest/society")
public class SocietyResource {
    private final SocietyService societyService;

    public SocietyResource(SocietyService societyService) {
        this.societyService = societyService;
    }

    @RequestMapping(value="admin/get", method = RequestMethod.GET)
    List<SocietyEntity> getSocieties(){
        return societyService.getAll();
    }

    @RequestMapping(value="resident/get/{societyId}", method = RequestMethod.GET)
    SocietyEntity getSocietyDetails(@PathVariable final Integer societyId){
        return societyService.getSocietyDetails(societyId);
    }

    @RequestMapping(value = "default/register/{userId}", method = RequestMethod.POST)
    public void registerSociety(@RequestBody SocietyEntity societyEntity, @PathVariable final Integer userId) throws Exception {
        societyService.create(societyEntity, userId);
    }

    @RequestMapping(value = "admin/update", method = RequestMethod.POST)
    public void updateSociety(@RequestBody SocietyEntity societyEntity) throws Exception {
         societyService.update(societyEntity);
    }
}
