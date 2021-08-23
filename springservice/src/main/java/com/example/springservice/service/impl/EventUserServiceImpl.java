package com.example.springservice.service.impl;

import com.example.springpublic.entity.event.Event;
import com.example.springpublic.entity.event.EventUser;
import com.example.springservice.dao.EventDao;
import com.example.springservice.dao.EventUserMapper;
import com.example.springservice.service.EventService;
import com.example.springservice.service.EventUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service(value = "eventService")
public class EventUserServiceImpl implements EventUserService {




    @Autowired
    private EventUserMapper eventUserMapper;//这里会报错，但是并不会影响

    @Override
    public int create(EventUser eventUser) {
        return  eventUserMapper.create(eventUser);
    }

    @Override
    public java.util.List<EventUser> queryByEventUser(EventUser eventUser) {
        return  eventUserMapper.queryByEventUser(eventUser);
    }
}

