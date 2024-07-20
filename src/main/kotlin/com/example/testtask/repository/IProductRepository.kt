package com.example.testtask.repository

import com.example.testtask.entity.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import java.util.*

interface IProductRepository: JpaRepository<Product,Int> {
    fun findByName(name: String): Product?
    override fun findById(id: Int): Optional<Product>
}