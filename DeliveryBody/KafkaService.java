package com.example.service;

import com.example.config.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService
{
    private Logger log = LoggerFactory.getLogger(KafkaService.class);
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public boolean updateLocation(String location)
    {


            log.info("message produced: ");
            this.kafkaTemplate.send(AppConstants.LOCATION_TOPIC_NAME,location);


        return true;
    }
}
