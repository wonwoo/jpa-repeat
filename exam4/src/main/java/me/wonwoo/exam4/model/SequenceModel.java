package me.wonwoo.exam4.model;

import javax.persistence.*;

/**
 * Created by wonwoo on 2016. 2. 20..
 */
@Entity
@SequenceGenerator(
        name = "SEQMODEL_SEQ_GENERATOR",
        sequenceName = "SEQMODEL_SEQ",
        initialValue = 1,
        allocationSize = 1
)
public class SequenceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQMODEL_SEQ_GENERATOR")
    private Long id;


}
