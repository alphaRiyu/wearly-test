package com.byteme.wearly.model.wearlier;

import com.byteme.wearly.model.couturier.servicetype.Sale;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 15, 2022 10:06 AM
 */

@Entity
@Data
@Table(name = "cartItem")
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {

    @GeneratedValue(strategy = IDENTITY)
    @Id
    @Column(name = "cartItemId")
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "wearlierId", referencedColumnName = "userId")
    private Wearlier wearlier;

    @ManyToOne
    @JoinColumn(name = "saleId", referencedColumnName = "clotheId")
    private Sale sale;

    @Column(name = "quantity", columnDefinition = "INT DEFAULT '0'")
    private int quantity;

    @Column(name = "createdAt", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt = new Date();
}
