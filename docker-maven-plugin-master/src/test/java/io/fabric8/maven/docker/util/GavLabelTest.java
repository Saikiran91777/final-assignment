package io.fabric8.maven.docker.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
 *
 * Copyright 2014 Roland Huss
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author roland
 * @since 31/03/15
 */
class GavLabelTest {

    String g = "io.fabric8";
    String a = "demo";
    String v = "0.0.1";
    String coord = g + ":" + a + ":" + v;

    @Test
    void simple() {
        GavLabel label = new GavLabel(g, a, v);
        Assertions.assertEquals(coord, label.getValue());
    }

    @Test
    void dontMatch() {
        GavLabel label = new GavLabel(g, a, v);
        Assertions.assertNotEquals(label, new GavLabel(g, a, "2.1.1"));
    }

    @Test
    void match() {
        GavLabel label = new GavLabel(g, a, v);
        Assertions.assertEquals(label, new GavLabel(g, a, v));
    }

    @Test
    void parse() {
        GavLabel label = new GavLabel(coord);
        Assertions.assertEquals(coord, label.getValue());
    }

    @Test
    void invalid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new GavLabel("bla"));
    }
}