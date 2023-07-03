package com.mjc.school.controller;

import java.util.List;

public interface Controller <Q,P>{

    List<P> getAll();

    P getById(Long id);

    P addNew(Q req);

    P update(Q req);

    Boolean deleteById(Long id);
}

