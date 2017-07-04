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

package com.design;

import org.apache.commons.lang3.StringUtils;

public class KnightBuilder implements SoldierBuilder {

    Knight knight;

    public KnightBuilder() {
        knight = new Knight();
    }

    public KnightBuilder withName(String name) {
        knight.setName(name);
        return this;
    }
    public KnightBuilder withArmor(boolean armor) {
        initArmor();

        if (armor && !knight.getArmor().contains("Knight armor")) {
            knight.setArmor("Knight armor " + knight.getArmor());
        }
        return this;
    }

    private void initArmor() {
        if (StringUtils.isBlank(knight.getArmor())) {
            knight.setArmor("");
        }
    }

    public KnightBuilder withShield(boolean shield) {
        initArmor();

        if (shield && !knight.getArmor().contains("shield")) {
            knight.setArmor("shield " + knight.getArmor());
        }
        return this;
    }

    public KnightBuilder withSword(boolean sword) {
        initWeapon();
        if (sword && !knight.getWeapon().contains("sword")) {
            knight.setWeapon("sword " + knight.getWeapon());
        }
        return this;
    }

    private void initWeapon() {
        if (StringUtils.isBlank(knight.getWeapon())) {
            knight.setWeapon("");
        }
    }

    public KnightBuilder withKnife(boolean knife) {
        initWeapon();
        if (knife && !knight.getWeapon().contains("knife")) {
            knight.setWeapon("knife " + knight.getWeapon());
        }
        return this;
    }

    public Knight build() {
        return knight;
    }
}
