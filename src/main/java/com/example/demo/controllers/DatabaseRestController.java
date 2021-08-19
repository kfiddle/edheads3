package com.example.demo.controllers;

import com.example.demo.models.MediaManagement;
import com.example.demo.models.USAState;
import com.example.demo.repositories.MediaManagementRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

@CrossOrigin
@RestController
public class DatabaseRestController {


    @Resource
    UserRepository userRepo;

    @Resource
    MediaManagementRepository mediaManagementRepo;


    @RequestMapping("/fetch-all-USAStates")
    public Collection<String> getTheStatesList() {
        Collection<String> listOfStates = new ArrayList<>();

        for (USAState state : USAState.values()) {
            listOfStates.add(state.toString());
        }
        return listOfStates;
    }

    @PostMapping("add-media")
    public void addNewMediaToDatabase(@RequestBody MediaManagement mediaToAdd) throws IOException {
        MediaManagement newMedia = new MediaManagement(mediaToAdd.getAdTagUrl(), mediaToAdd.getPageTitle(),
                mediaToAdd.getColumnPositionA(), mediaToAdd.getColumnPositionB(), mediaToAdd.getColumnPositionC());

        mediaManagementRepo.save(newMedia);

//        if (!mediaManagementRepo.existsByAdTagUrl() && !mediaManagementRepo.existsByPageTitle()) {
//            mediaManagementRepo.save(newMedia);
//        }
    }

    @RequestMapping("/fetch-all-media")
    public Collection<MediaManagement> getAllMediaInDatabase() {
        return (Collection<MediaManagement>) mediaManagementRepo.findAll();
    }

}
