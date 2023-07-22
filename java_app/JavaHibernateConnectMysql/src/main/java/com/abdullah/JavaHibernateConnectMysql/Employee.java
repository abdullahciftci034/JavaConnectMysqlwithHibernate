package com.abdullah.JavaHibernateConnectMysql;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "name")
    public String name;

    @Column(name = "age")
    public int age;

    // Constructors, getters, setters, etc.
}
