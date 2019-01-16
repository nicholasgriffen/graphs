package com.griffen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EdgeTest {
    //from
    //to
    //weight
    @Test
    public void itMakesEdges() {
        Edge edge = new Edge("A", "B", 3);
        assertTrue(edge instanceof Edge);
    }
}
