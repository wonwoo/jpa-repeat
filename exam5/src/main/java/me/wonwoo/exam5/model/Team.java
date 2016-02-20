package me.wonwoo.exam5.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by wonwoo on 2016. 2. 20..
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Team {

    @Id
    @Column(name = "TEAM_ID")
    private String id;
    private String name;
}
