package com.test.challenge.producer;

import org.springframework.stereotype.Service;

@Service
public class ProducerServiceImpl implements ProducerService {

    @Override
    /**
     * Mock implementation, should use some store and logic
     */
    //FIXME
    public String getProducerNameById(long id) {
        return "Producer";
    }
}
