/*
 * Copyright (C) 2009 Mathias Doenitz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.parboiled.common;

import org.parboiled.Node;
import static org.parboiled.common.Utils.getTypeArguments;
import org.parboiled.support.NodeFormatter;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import java.util.ArrayList;

import com.google.common.collect.ImmutableList;
import com.google.common.base.Predicate;

public class UtilsTest {

    @SuppressWarnings({"InstantiatingObjectToGetClassObject"})
    @Test
    public void testGetTypeArguments() {
        assertEquals(getTypeArguments(ArrayList.class, new ArrayList<String>() {
        }.getClass()), ImmutableList.of(String.class));

        assertEquals(getTypeArguments(Predicate.class, new Predicate<Integer>() {
            public boolean apply(Integer i) {
                return true;
            }
        }.getClass()), ImmutableList.of(Integer.class));

        assertEquals(getTypeArguments(Formatter.class, NodeFormatter.class), ImmutableList.of(Node.class));
    }

}
