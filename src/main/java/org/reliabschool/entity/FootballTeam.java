package org.reliabschool.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FootballTeam {

    String name;

    String city;

    Integer leaguePosition;

    Integer victoriesNum;

}
