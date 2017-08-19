/*
 * MIT License
 *
 * Copyright (c) 2017 Andy Holst
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.design.prototype;

import com.design.factory.CarModel;
import com.design.factory.VolvoCar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarPrototypeFactoryTest {
    @Test
    public void testCarProtoTypeFactory() {
        CarPrototypeFactory carPrototypeFactory = null;

        assertNull(carPrototypeFactory);

        carPrototypeFactory = new CarPrototypeFactory();

        CarModel carModel1 = carPrototypeFactory.createCar(new VolvoCar());

        assertEquals("Volvo", carModel1.getCarModel("").trim());

        CarModel carModel2 = carPrototypeFactory.createCar(carModel1);

        assertEquals("Volvo X", carModel2.getCarModel("X"));

        assertNotEquals(carModel1, carModel2);
    }
}