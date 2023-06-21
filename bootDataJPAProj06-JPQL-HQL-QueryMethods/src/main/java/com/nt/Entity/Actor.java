package com.nt.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "DATA_JPA_ACTOR")
@Data

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor

public class Actor {

	@Column(name = "ACTOR_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer aid;
	
	@Column(name = "ACTOR_NAME", length = 20)
	@NonNull
	private String aname;
	@Column(name = " CATEGORY", length = 20)
	@NonNull
	private String category;
	@Column(name = "MOBILENO")
	@NonNull
	private Long mobileNo;
	@Column(name = "Status", length = 1)
	@NonNull
	private Long status;
}
