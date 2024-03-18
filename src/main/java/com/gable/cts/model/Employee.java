package com.gable.cts.model;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "employee")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id")
public class Employee
{

  @Id
  @Column(name = "id" )
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "first_name")
  private String firstName;
  
  @Column(name = "last_name")
  private String lastName;
  
  @Column(name = "employee_id")
  private String employeeID;
  
  @Column(name = "import_date")
  private LocalDate importDate;
  
  @OneToOne()
  @JoinColumn(name = "user_id")
  private User user;
  
  //Employee Associations

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee",cascade = CascadeType.ALL)
  @JsonIgnoreProperties("employee")
  private List<OwnCert> ownList;
 
  @ManyToOne()
  @JoinColumn(name = "organization_id")
  @JsonIgnoreProperties({"manager", "staffs"})
  private Organization organization;
  
  @Transient
  private String organizationFull = "SMT/AAPP/DB/PDD/DOO";
  
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee",cascade = CascadeType.ALL)
  @JsonIgnoreProperties("employee")
  private List<Notification> notifications;

  public String getOrganizationFull() {
	return organization.getFullName();
  }

  public Long getOrganizationId() {
	  return organization.getId();
  }

  @Override
  public String toString() {
      return "Employee{" +
              "id=" + id +
              ", firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              ", employeeID='" + employeeID + '\'' +
              ", importDate=" + importDate +
              ", user=" + user +
              ", ownList=" + ownList +
              ", organization=" + organization +
              ", notifications=" + notifications +
              '}';
  }

}