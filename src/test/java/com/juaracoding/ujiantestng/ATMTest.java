package com.juaracoding.ujiantestng;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ATMTest {
    private ATM atm;

    @BeforeMethod
    public void setUp() {
        atm = new ATM(1000); // Saldo awal 1000
    }

    @Test
    public void testLihatSaldo() {
        double saldo = atm.lihatSaldo();
        Assert.assertEquals(saldo, 1000, "Saldo awal tidak sesuai.");
    }

    @Test
    public void testSetorUang() {
        atm.setorUang(500);
        double saldo = atm.lihatSaldo();
        Assert.assertEquals(saldo, 1500, "Saldo setelah setor uang tidak sesuai.");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSetorUangNegatif() {
        atm.setorUang(-100);
    }

    @Test
    public void testTarikUang() {
        atm.tarikUang(300);
        double saldo = atm.lihatSaldo();
        Assert.assertEquals(saldo, 700, "Saldo setelah tarik uang tidak sesuai.");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTarikUangLebihDariSaldo() {
        atm.tarikUang(1100);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTarikUangNegatif() {
        atm.tarikUang(-100);
    }
}

