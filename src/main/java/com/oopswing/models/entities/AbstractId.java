package com.oopswing.models.entities;

import javax.persistence.*;

@MappedSuperclass
public class AbstractId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
