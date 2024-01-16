package com.example.hibernate.invoice.dao;

import com.example.hibernate.invoice.Invoice;
import com.example.hibernate.invoice.Item;
import com.example.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotEquals;


@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    @Transactional
    void testInvoiceDaoSave() {
        //Given
        Product set75372 = new Product("Clone Trooper & Battle Droid Battle Pack");
        Product set75345 = new Product("501st Clone Troopers Battle Pack");
        Product set75354= new Product("Coruscant Guard Gunship");

        Item battlePack1 = new Item(BigDecimal.valueOf(139.99), 2);
        Item battlePack2 = new Item(BigDecimal.valueOf(999.99), 4);
        Item playSet = new Item(BigDecimal.valueOf(689.99), 3);

        battlePack1.setProduct(set75372);
        battlePack2.setProduct(set75345);
        playSet.setProduct(set75354);

        Invoice invoice = new Invoice("pay it");

        invoice.getItems().add(battlePack1);
        invoice.getItems().add(battlePack2);
        invoice.getItems().add(playSet);

        //When
        invoiceDao.save(invoice);

        int id = invoice.getId();

        //Then
        assertNotEquals(0, id);

        //CleanUp

        invoiceDao.deleteById(id);


    }
}
