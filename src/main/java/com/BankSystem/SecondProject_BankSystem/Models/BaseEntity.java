package com.BankSystem.SecondProject_BankSystem.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@Setter
@Getter
@Data
@MappedSuperclass
public class BaseEntity {

        @CreatedDate
        Date createdDate;
        @UpdateTimestamp
        Date UpdatedDate;
        Boolean isActive;
}
