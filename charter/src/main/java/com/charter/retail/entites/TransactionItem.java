package com.charter.retail.entites;

import java.math.BigDecimal;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@javax.persistence.SequenceGenerator(name = "tran_item_id",initialValue = 1001,sequenceName ="tran_item_id" )
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "tran_item_id")
    @Getter @Setter private Long id;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    @Getter @Setter private Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "item_id")
    @Getter @Setter private Item item;

    @Getter @Setter private Integer quantity;
    @Getter @Setter private BigDecimal priceAtPurchase;
    @Getter @Setter private BigDecimal subtotal;

}
