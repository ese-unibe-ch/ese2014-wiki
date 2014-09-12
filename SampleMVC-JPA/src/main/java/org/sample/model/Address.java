package org.sample.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Address {
	  @Id
	    @GeneratedValue
	    private Long id;

	    private String street;
	    
	    @ManyToOne          // always specify the type of relationship:  ManyToMany, OneToOne, ManyToOne, 
	    private User user;


		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User u) {
			this.user = u;
		}
	    
	    
	  
}
