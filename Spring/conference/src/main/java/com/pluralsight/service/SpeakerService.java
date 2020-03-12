package com.pluralsight.service;

import java.util.List;

import com.pluralsight.model.Speaker;

/**
 * SpeakerService
 */
public interface SpeakerService {

    List<Speaker> findAll();
}