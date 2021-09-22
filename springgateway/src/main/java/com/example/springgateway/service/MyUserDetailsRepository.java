package com.example.springgateway.service;

import com.example.springpublic.entity.event.EventUser;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

/**
 * @author: ffzs
 * @Date: 2020/8/12 上午9:14
 */
public interface MyUserDetailsRepository extends ReactiveCrudRepository<EventUser, Long> {

    Mono<EventUser> findByUsername (String username);

}
