package com.charter.retail.entites;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@javax.persistence.SequenceGenerator(name = "item_id",initialValue = 100,sequenceName ="item_id" )
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "item_id")
    @Getter @Setter private Long id;
    @Getter @Setter private String name;
    @Getter @Setter private Long price;
    @Getter @Setter private String description;
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    @Getter @Setter private List<TransactionItem> transactionItems = new ArrayList<>();
}
