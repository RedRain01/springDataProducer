package com.example.springservice.service.impl;

import com.example.springpublic.entity.event.Event;
import com.example.springservice.dao.EventDao;
import com.example.springservice.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service(value = "eventService")
public class EventServiceImpl implements EventService {




    @Autowired
    private EventDao EventDao;//这里会报错，但是并不会影响

    @Override
    public int create(Event event) {
        return  EventDao.create(event);
    }

    @Override
    public Event queryByPk(Integer eventId) {
        return null;
    }

    @Override
    public int updateByPk(Event event) {
        return 0;
    }

    @Override
    public int deleteByPk(Integer eventId) {
        return 0;
    }

    @Override
    public List<Event> queryByEvent(Event event) {
        return null;
    }

    @Override
    public List<Event> queryByPage(Map paramMap) {
        return null;
    }

    @Override
    public long countByCondtion(Map paramMap) {
        return 0;
    }
}

