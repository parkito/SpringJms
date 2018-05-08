package ru.siksmfp.spring.jms.publisher.repository.impl;

import org.springframework.stereotype.Repository;
import ru.siksmfp.spring.jms.publisher.entity.Data;
import ru.siksmfp.spring.jms.publisher.repository.api.GenericRepository;

/**
 * @author Artem Karnov @date 4/17/2018.
 * @email artem.karnov@t-systems.com
 */
@Repository
public class EntityRepository extends GenericRepository<Data, Long> {

}
