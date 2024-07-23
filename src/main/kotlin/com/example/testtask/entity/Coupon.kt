package com.example.testtask.entity

import jakarta.persistence.*

@Entity
@Table(name="coupon")
class Coupon (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long =0,

    @Column(name = "code")
    var name: String,
    )