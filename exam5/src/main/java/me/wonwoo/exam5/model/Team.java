package me.wonwoo.exam5.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

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


    public Team(String id, String name){
        this.id = id;
        this.name = name;
    }

    @OneToMany(mappedBy = "team")
    private List<Member5> members = new ArrayList<>();
}
