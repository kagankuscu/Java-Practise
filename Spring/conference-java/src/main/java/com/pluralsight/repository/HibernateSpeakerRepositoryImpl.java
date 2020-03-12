package com.pluralsight.repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.pluralsight.model.Speaker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository("speakerRepostiry")
// @Profile("dev")
public class HibernateSpeakerRepositoryImpl implements SpeakerRepository {

    @Autowired
    private Calendar cal;

    @Value ("#{ T(java.lang.Math).random() * 100.0 }")
    private double seedNum;

    public List<Speaker> findAll() {
        List<Speaker> speakers = new ArrayList<>();

        Speaker speaker = new Speaker();
 
        speaker.setFirsName("Kagan");
        speaker.setLastName("KUSCU");

        System.out.println("Cal:" + cal.getTime());
        
        speakers.add(speaker);

        return speakers;
    }
}