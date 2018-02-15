package com.climate.android.conversions;


import junit.framework.Assert;

import org.junit.Test;

public class SeedsPerAreaUnitTest {

    @Test
    public void testSeedsPerAc() {
        Assert.assertEquals(45.0, SeedsPerAreaUnit.SEEDS_PER_AC.toSeedsPerAc(45));
        Assert.assertEquals(2.47105, SeedsPerAreaUnit.SEEDS_PER_AC.toSeedsPerHa(1));
    }

    @Test
    public void testSeedsPerHa() {
        Assert.assertEquals(0.4046862669715303, SeedsPerAreaUnit.SEEDS_PER_HA.toSeedsPerAc(1));
        Assert.assertEquals(45.0, SeedsPerAreaUnit.SEEDS_PER_HA.toSeedsPerHa(45));
    }

}