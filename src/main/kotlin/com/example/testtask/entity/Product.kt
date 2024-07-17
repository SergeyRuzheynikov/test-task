package com.example.testtask.entity

import jakarta.persistence.*

@Entity
@Table(name="product")
class Product (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long =0,
    var name: String,
    var price: Double
)