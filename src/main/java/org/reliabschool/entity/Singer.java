package org.reliabschool.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Singer {

    String artistName;

    Integer rating;

    Integer releasedAlbumsAmount;
}
