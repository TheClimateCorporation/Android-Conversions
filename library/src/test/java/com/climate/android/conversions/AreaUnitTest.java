package com.climate.android.conversions;


import junit.framework.Assert;

import org.junit.Test;

public class AreaUnitTest {

    @Test
    public void testSqInches() {
        Assert.assertEquals(45.0, AreaUnit.SQ_INCHES.toSquareInches(45));
        Assert.assertEquals(0.3125, AreaUnit.SQ_INCHES.toSquareFeet(45));
        Assert.assertEquals(.5, AreaUnit.SQ_INCHES.toSquareYards(648));
        Assert.assertEquals(.030752798313389576, AreaUnit.SQ_INCHES.toSquareMiles(123456789), 1e-10);
        Assert.assertEquals(.1, AreaUnit.SQ_INCHES.toAcres(627264));

        Assert.assertEquals(1.0, AreaUnit.SQ_INCHES.toSquareMeters(1550));
        Assert.assertEquals(.07964938199124, AreaUnit.SQ_INCHES.toSquareKilometers(123456789), 1e-10);
        Assert.assertEquals(.0019354818730509698, AreaUnit.SQ_INCHES.toHectares(30000), 1e-10);
    }


    @Test
    public void testSqFeet() {
        Assert.assertEquals(288D, AreaUnit.SQ_FEET.toSquareInches(2));
        Assert.assertEquals(2D, AreaUnit.SQ_FEET.toSquareFeet(2));
        Assert.assertEquals(2D, AreaUnit.SQ_FEET.toSquareYards(18));
        Assert.assertEquals(0.00717401286, AreaUnit.SQ_FEET.toSquareMiles(200000), 1e-10);
        Assert.assertEquals(0.04591368227731864, AreaUnit.SQ_FEET.toAcres(2000), 1e-10);

        Assert.assertEquals(3.0658064516129033, AreaUnit.SQ_FEET.toSquareMeters(33), 1e-10);
        Assert.assertEquals(11.469511006738559, AreaUnit.SQ_FEET.toSquareKilometers(123456789), 1e-10);
        Assert.assertEquals(0.2787093897193396, AreaUnit.SQ_FEET.toHectares(30000), 1e-10);
    }

    @Test
    public void testSqYards() {
        Assert.assertEquals(2592D, AreaUnit.SQ_YARDS.toSquareInches(2));
        Assert.assertEquals(18D, AreaUnit.SQ_YARDS.toSquareFeet(2));
        Assert.assertEquals(2D, AreaUnit.SQ_YARDS.toSquareYards(2));
        Assert.assertEquals(0.06456611570247933, AreaUnit.SQ_YARDS.toSquareMiles(200000), 1e-10);
        Assert.assertEquals(0.4132231404958678, AreaUnit.SQ_YARDS.toAcres(2000), 1e-10);

        Assert.assertEquals(27.59225806451613, AreaUnit.SQ_YARDS.toSquareMeters(33), 1e-10);
        Assert.assertEquals(103.22559906064704, AreaUnit.SQ_YARDS.toSquareKilometers(123456789), 1e-10);
        Assert.assertEquals(2.508384507474057, AreaUnit.SQ_YARDS.toHectares(30000), 1e-10);
    }

    @Test
    public void testSqMiles() {
        Assert.assertEquals(20072448D, AreaUnit.SQ_MILES.toSquareInches(.005));
        Assert.assertEquals(139392D, AreaUnit.SQ_MILES.toSquareFeet(.005));
        Assert.assertEquals(15488D, AreaUnit.SQ_MILES.toSquareYards(.005));
        Assert.assertEquals(.005, AreaUnit.SQ_MILES.toSquareMiles(.005), 1e-10);
        Assert.assertEquals(1280D, AreaUnit.SQ_MILES.toAcres(2), 1e-10);

        Assert.assertEquals(12949.940551680002, AreaUnit.SQ_MILES.toSquareMeters(.005), 1e-10);
        Assert.assertEquals(2.5899881103360003, AreaUnit.SQ_MILES.toSquareKilometers(1), 1e-10);
        Assert.assertEquals(1.2949952, AreaUnit.SQ_MILES.toHectares(.005), 1e-10);
    }

    @Test
    public void testAcres() {
        Assert.assertEquals(31363.2, AreaUnit.ACRES.toSquareInches(.005));
        Assert.assertEquals(217.8, AreaUnit.ACRES.toSquareFeet(.005));
        Assert.assertEquals(24.2, AreaUnit.ACRES.toSquareYards(.005));
        Assert.assertEquals(0.5, AreaUnit.ACRES.toSquareMiles(320), 1e-10);
        Assert.assertEquals(320D, AreaUnit.ACRES.toAcres(320), 1e-10);

        Assert.assertEquals(20.234282112, AreaUnit.ACRES.toSquareMeters(.005), 1e-10);
        Assert.assertEquals(1.294994055168, AreaUnit.ACRES.toSquareKilometers(320), 1e-10);
        Assert.assertEquals(129.49952, AreaUnit.ACRES.toHectares(320), 1e-10);
    }

    @Test
    public void testSqMeters() {
        Assert.assertEquals(3100.0062000124, AreaUnit.SQ_METERS.toSquareInches(2), 1e-10);
        Assert.assertEquals(21.527820833419444, AreaUnit.SQ_METERS.toSquareFeet(2), 1e-10);
        Assert.assertEquals(2.3919800926021604, AreaUnit.SQ_METERS.toSquareYards(2), 1e-10);
        Assert.assertEquals(0.0007722036344227377, AreaUnit.SQ_METERS.toSquareMiles(2000), 1e-10);
        Assert.assertEquals(.49421032603055215, AreaUnit.SQ_METERS.toAcres(2000), 1e-10);

        Assert.assertEquals(2000D, AreaUnit.SQ_METERS.toSquareMeters(2000), 1e-10);
        Assert.assertEquals(.002, AreaUnit.SQ_METERS.toSquareKilometers(2000), 1e-10);
        Assert.assertEquals(0.2, AreaUnit.SQ_METERS.toHectares(2000), 1e-10);
    }

    @Test
    public void testSqKilometers() {
        Assert.assertEquals(1550003100.0061998, AreaUnit.SQ_KILOMETERS.toSquareInches(1), 1e-10);
        Assert.assertEquals(215.27820833419443, AreaUnit.SQ_KILOMETERS.toSquareFeet(.00002), 1e-10);
        Assert.assertEquals(2391.9800926021603, AreaUnit.SQ_KILOMETERS.toSquareYards(.002), 1e-10);
        Assert.assertEquals(.7722036344227377, AreaUnit.SQ_KILOMETERS.toSquareMiles(2), 1e-10);
        Assert.assertEquals(494.2103260305521, AreaUnit.SQ_KILOMETERS.toAcres(2), 1e-10);

        Assert.assertEquals(2e+6, AreaUnit.SQ_KILOMETERS.toSquareMeters(2), 1e-10);
        Assert.assertEquals(2D, AreaUnit.SQ_KILOMETERS.toSquareKilometers(2), 1e-10);
        Assert.assertEquals(200D, AreaUnit.SQ_KILOMETERS.toHectares(2), 1e-10);
    }

    @Test
    public void testHectares() {
        Assert.assertEquals(1550003100.0061998, AreaUnit.HECTARES.toSquareInches(100), 1e-10);
        Assert.assertEquals(215.27820833419443, AreaUnit.HECTARES.toSquareFeet(.002), 1e-10);
        Assert.assertEquals(2391.9800926021603, AreaUnit.HECTARES.toSquareYards(.2), 1e-10);
        Assert.assertEquals(.7722036344227377, AreaUnit.HECTARES.toSquareMiles(200), 1e-10);
        Assert.assertEquals(494.2103260305521, AreaUnit.HECTARES.toAcres(200), 1e-10);

        Assert.assertEquals(2e+6, AreaUnit.HECTARES.toSquareMeters(200), 1e-10);
        Assert.assertEquals(2D, AreaUnit.HECTARES.toSquareKilometers(200), 1e-10);
        Assert.assertEquals(200D, AreaUnit.HECTARES.toHectares(200), 1e-10);
    }

}