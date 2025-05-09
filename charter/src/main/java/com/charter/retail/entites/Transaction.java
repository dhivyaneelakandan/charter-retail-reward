package com.charter.retail.entites;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@javax.persistence.SequenceGenerator(name = "tran_id",initialValue = 10001,sequenceName ="tran_id" )
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data 
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "tran_id")
    @Getter @Setter private Long id;

    @Getter @Setter private Long amount;
    @Getter @Setter private LocalDateTime transactionDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @Getter @Setter private CustomerInfo customer;

    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL)
    @Getter @Setter private List<TransactionItem> items = new ArrayList<>();

    @OneToOne(mappedBy = "transaction", cascade = CascadeType.ALL)
    @Getter @Setter private Reward reward;
}
