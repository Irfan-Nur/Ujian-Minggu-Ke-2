package com.juaracoding.ujiantestng;

public class ATM {
    private double saldo;

    public ATM(double saldoAwal){
        this.saldo = saldoAwal;
        if (saldoAwal < 0){
            throw new IllegalArgumentException("Saldo awal tidak boleh negatif");
        }
    }
    public double lihatSaldo(){
        return saldo;
    }

    public void setorUang(double jumlah){
        if (jumlah > 0){
            saldo+= jumlah;
        }else {
            throw new IllegalArgumentException("Jumlah harus lebih besar dari 0");
        }
    }
    public void tarikUang(double jumlah) {
        if (jumlah > 0 && jumlah <= saldo) {
            saldo -= jumlah;
        } else if (jumlah > saldo) {
            throw new IllegalArgumentException("Saldo tidak mencukupi");
        } else {
            throw new IllegalArgumentException("Jumlah harus lebih besar dari 0");
        }
    }
    public static void main(String[] args) {
        try{
            ATM atm = new ATM(100000);
            System.out.println("Saldo saati ini: "+atm.lihatSaldo());
            atm.setorUang(50000);
            System.out.println("Saldo anda setelah setor: "+atm.lihatSaldo());
            atm.tarikUang(20000);
            System.out.println("Saldo anda setelah tarik tunai: "+atm.lihatSaldo());
        }catch (IllegalArgumentException e){
            System.out.println("Error : "+ e.getMessage());
        }
    }
}




