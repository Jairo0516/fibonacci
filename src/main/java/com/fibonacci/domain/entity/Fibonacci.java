package com.fibonacci.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.joda.time.DateTime;

import java.util.Date;

@Entity
@Data
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name = "fibonacci_transacction", schema = "public")
public class Fibonacci {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Integer id;

    @Column(name = "fibonacci")
    private String fibonacci;

    @Column(name = "create_at")
    private Date cretaeAt;

    @Column(name = "modiffy_at")
    private Date modiffyAt;
}
