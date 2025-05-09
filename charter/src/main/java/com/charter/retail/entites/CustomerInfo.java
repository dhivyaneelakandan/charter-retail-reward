package com.charter.retail.entites;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@javax.persistence.SequenceGenerator(name = "cust_id",initialValue = 1009,sequenceName ="cust_id" )
public class CustomerInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Getter @Setter private String email;
	@Getter @Setter private String mobile ;
	@Getter @Setter private String name;
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	@Getter @Setter private List<Transaction> transactions = new ArrayList<>();
}