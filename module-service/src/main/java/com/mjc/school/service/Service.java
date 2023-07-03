package com.mjc.school.service;

import java.util.List;

public interface Service <Q,P>{

    List<P> getAll();

    P getById(Long id);

    P addNew(Q req);

    P update(Q req);

    Boolean deleteById(Long id);
}
