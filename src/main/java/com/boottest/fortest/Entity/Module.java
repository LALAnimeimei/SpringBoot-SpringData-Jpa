package com.boottest.fortest.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Module")
public class Module implements Serializable {
    private static final long serialVersionUID = -6735949098533146567L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int  id;

    @Column
    private String url;

    @Column
    private String name;

    @Column
    private int parentid;


}
