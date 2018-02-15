package com.climate.android.conversions;

import junit.framework.Assert;

import org.junit.Test;


public class LengthUnitTest {


    @Test
    public void testMillimeters() {
        Assert.assertEquals(200.0, LengthUnit.MILLIMETERS.toMillis(200));
        Assert.assertEquals(20.0, LengthUnit.MILLIMETERS.toCentis(200));
        Assert.assertEquals(.2, LengthUnit.MILLIMETERS.toMeters(200));
        Assert.assertEquals(.012356, LengthUnit.MILLIMETERS.toKilometers(12356), 0.05f);

        Assert.assertEquals(10.0, LengthUnit.MILLIMETERS.toInches(254));
        Assert.assertEquals(0.833333, LengthUnit.MILLIMETERS.toFeet(254), 0.05f);
        Assert.assertEquals(1.0, LengthUnit.MILLIMETERS.toYards(914.4));
        Assert.assertEquals(7.6712486578, LengthUnit.MILLIMETERS.toMiles(12345678), 0.05f);
    }

    @Test
    public void testCentimeters() {
        Assert.assertEquals(200.0, LengthUnit.CENTIMETERS.toMillis(20));
        Assert.assertEquals(20.0, LengthUnit.CENTIMETERS.toCentis(20));
        Assert.assertEquals(.2, LengthUnit.CENTIMETERS.toMeters(20));
        Assert.assertEquals(.012356, LengthUnit.CENTIMETERS.toKilometers(1235.6), 0.05f);

        Assert.assertEquals(10.0, LengthUnit.CENTIMETERS.toInches(25.4));
        Assert.assertEquals(0.833333, LengthUnit.CENTIMETERS.toFeet(25.4), 0.05f);
        Assert.assertEquals(1.0, LengthUnit.CENTIMETERS.toYards(91.44));
        Assert.assertEquals(7.6712486578, LengthUnit.CENTIMETERS.toMiles(1234567.8), 0.05f);
    }

    @Test
    public void testMeters() {
        Assert.assertEquals(20000.0, LengthUnit.METERS.toMillis(20));
        Assert.assertEquals(2000.0, LengthUnit.METERS.toCentis(20));
        Assert.assertEquals(20.0, LengthUnit.METERS.toMeters(20));
        Assert.assertEquals(1.2356, LengthUnit.METERS.toKilometers(1235.6), 0.05f);

        Assert.assertEquals(1000.0, LengthUnit.METERS.toInches(25.4));
        Assert.assertEquals(83.3333, LengthUnit.METERS.toFeet(25.4), 0.05f);
        Assert.assertEquals(100.0, LengthUnit.METERS.toYards(91.44));
        Assert.assertEquals(767.124865784, LengthUnit.METERS.toMiles(1234567.8), 0.05f);
    }

    @Test
    public void testKillometers() {
        Assert.assertEquals(2E7, LengthUnit.KILOMETERS.toMillis(20));
        Assert.assertEquals(2000000.0, LengthUnit.KILOMETERS.toCentis(20));
        Assert.assertEquals(20000.0, LengthUnit.KILOMETERS.toMeters(20));
        Assert.assertEquals(1235.6, LengthUnit.KILOMETERS.toKilometers(1235.6), 0.05f);

        Assert.assertEquals(1000000.0, LengthUnit.KILOMETERS.toInches(25.4));
        Assert.assertEquals(83333.3, LengthUnit.KILOMETERS.toFeet(25.4), 0.05f);
        Assert.assertEquals(100000D, LengthUnit.KILOMETERS.toYards(91.44));
        Assert.assertEquals(767124.8657838225, LengthUnit.KILOMETERS.toMiles(1234567.8), 0.0000001);
    }

    @Test
    public void testInches() {
        Assert.assertEquals(254.0, LengthUnit.INCHES.toMillis(10));
        Assert.assertEquals(25.4, LengthUnit.INCHES.toCentis(10));
        Assert.assertEquals(0.254, LengthUnit.INCHES.toMeters(10));
        Assert.assertEquals(0.000254, LengthUnit.INCHES.toKilometers(10), 0.00001);

        Assert.assertEquals(10.0, LengthUnit.INCHES.toInches(10));
        Assert.assertEquals(1.5, LengthUnit.INCHES.toFeet(18), 0.05f);
        Assert.assertEquals(1.0, LengthUnit.INCHES.toYards(36));
        Assert.assertEquals(1.94848485, LengthUnit.INCHES.toMiles(123456), .0000001);
    }

    @Test
    public void testFeet() {
        Assert.assertEquals(3048.0, LengthUnit.FEET.toMillis(10));
        Assert.assertEquals(304.8, LengthUnit.FEET.toCentis(10));
        Assert.assertEquals(3.048, LengthUnit.FEET.toMeters(10));
        Assert.assertEquals(0.003048, LengthUnit.FEET.toKilometers(10), 0.00001);

        Assert.assertEquals(120.0, LengthUnit.FEET.toInches(10));
        Assert.assertEquals(18.0, LengthUnit.FEET.toFeet(18), 0.05f);
        Assert.assertEquals(12.0, LengthUnit.FEET.toYards(36));
        Assert.assertEquals(0.5, LengthUnit.FEET.toMiles(2640), .01);
    }

    @Test
    public void testYards() {
        Assert.assertEquals(9144.0, LengthUnit.YARDS.toMillis(10));
        Assert.assertEquals(914.4, LengthUnit.YARDS.toCentis(10));
        Assert.assertEquals(9.144, LengthUnit.YARDS.toMeters(10));
        Assert.assertEquals(.9144, LengthUnit.YARDS.toKilometers(1000), 0.00001);

        Assert.assertEquals(360.0, LengthUnit.YARDS.toInches(10));
        Assert.assertEquals(54.0, LengthUnit.YARDS.toFeet(18), 0.05f);
        Assert.assertEquals(36.0, LengthUnit.YARDS.toYards(36));
        Assert.assertEquals(1.5, LengthUnit.YARDS.toMiles(2640), .01);
    }

    @Test
    public void testMiles() {
        Assert.assertEquals(402336.0, LengthUnit.MILES.toMillis(0.25));
        Assert.assertEquals(40233.6, LengthUnit.MILES.toCentis(0.25));
        Assert.assertEquals(402.336, LengthUnit.MILES.toMeters(0.25));
        Assert.assertEquals(.402336, LengthUnit.MILES.toKilometers(0.25), .000001);

        Assert.assertEquals(15840.0, LengthUnit.MILES.toInches(0.25));
        Assert.assertEquals(1320.0, LengthUnit.MILES.toFeet(0.25), 0.05f);
        Assert.assertEquals(440.0, LengthUnit.MILES.toYards(0.25));
        Assert.assertEquals(0.25, LengthUnit.MILES.toMiles(0.25), .01);
    }


}