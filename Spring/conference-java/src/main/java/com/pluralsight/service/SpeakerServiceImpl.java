package com.pluralsight.service;

import java.util.List;

import com.pluralsight.model.Speaker;
import com.pluralsight.repository.SpeakerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service("speakerService")
// @Profile("dev")
public class SpeakerServiceImpl implements SpeakerService {

    private SpeakerRepository repository;

    public List<Speaker> findAll() {
        return repository.findAll();
    }
    
    public void setRepository(SpeakerRepository repository) {
        System.out.println("SpeakerServiceImpl setter method.");
        this.repository = repository;
    }

    @Autowired
	public SpeakerServiceImpl(SpeakerRepository speakerRepository) {
        System.out.println("SpeakerServiceImpl with args Constructor.");
        repository = speakerRepository;
    }
    
    public SpeakerServiceImpl(){
        System.out.println("SpeakerServiceImpl no args Constructor.");
    }
}