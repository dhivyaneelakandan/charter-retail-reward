package com.charter.retail.entites;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@javax.persistence.SequenceGenerator(name = "reward_id",initialValue = 10001,sequenceName ="reward_id" )
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reward {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "reward_id")
    @Getter @Setter private Long id;
    @Getter @Setter private Integer points;
    @OneToOne
    @JoinColumn(name = "transaction_id")
    @Getter @Setter private Transaction transaction;
}

