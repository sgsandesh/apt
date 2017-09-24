package com.mySociety.resources;

import com.mySociety.model.orm.basic.SocietyResidenceEntity;
import com.mySociety.model.view.basic.SocietyResidenceView;
import com.mySociety.services.basic.SocietyResidenceService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by sandesh on 10/9/17.
 */
@RestController
@RequestMapping("/society-residence")
public class SocietyResidenceResource {
    private final SocietyResidenceService societyResidenceService;

    public SocietyResidenceResource(SocietyResidenceService societyResidenceService) {
        this.societyResidenceService = societyResidenceService;
    }


    @RequestMapping(value = "resident/get/{societyId}", method = RequestMethod.GET)
    Set<SocietyResidenceEntity> getSocietyResidences(@PathVariable final Integer societyId){
        return societyResidenceService.fetchResidences(societyId);
    }

    @RequestMapping(value = "admin/add", method = RequestMethod.POST)
    public void addResidenceToSociety(@RequestBody SocietyResidenceView societyResidenceView) throws Exception {
         societyResidenceService.add(societyResidenceView);
    }

    @RequestMapping(value = "admin/remove", method = RequestMethod.POST)
    public void removeResidenceToSociety(@RequestBody SocietyResidenceView societyResidenceView) throws Exception {
        societyResidenceService.remove(societyResidenceView);
    }

    @RequestMapping(value = "resident/intercom/update", method = RequestMethod.POST)
    public void updateIntercom(@RequestBody SocietyResidenceView societyResidenceView) throws Exception {
        societyResidenceService.updateIntercom(societyResidenceView);
    }
}
