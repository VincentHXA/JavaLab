package jdk8;

import com.oracle.xmlns.internal.webservices.jaxws_databinding.SoapBindingParameterStyle;

public class DefaultMethods {

    public static void main(String[] args) {
       Vehicle vehicle = new Car();
       vehicle.print();
    }
}

interface Vehicle {
    default void print() {
        System.out.println("im a car");
    }

    static void blowHorn() {
        System.out.println("zhi.");
    }
}

interface FourWheeler {
    default void print() {
        System.out.println("im a four-wheel car");
    }
}

class Car implements Vehicle, FourWheeler {
    public void print() {
        Vehicle.super.print();
        FourWheeler.super.print();
        Vehicle.blowHorn();
    }
}
