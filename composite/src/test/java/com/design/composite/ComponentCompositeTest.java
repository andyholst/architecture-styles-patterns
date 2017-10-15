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

package com.design.composite;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComponentCompositeTest {

    @Test
    public void testCharacter() {
        Component characterComponent = new CharacterComponent('h');

        assertEquals("h", characterComponent.getSymbol());

        assertEquals(0, characterComponent.getComponentList().size());

    }

    @Test
    public void testWord() {
        Component wordComponent = getWordComponent("hello");

        assertEquals(5, wordComponent.getComponentList().size());

        assertEquals("hello", wordComponent.getSymbol());
    }

    @Test
    public void testSentence() {
        List<WordComponent> wordComponentList = new ArrayList<>();

        wordComponentList.add(getWordComponent("Hello"));
        wordComponentList.add(getWordComponent("there"));

        Component sentenceComponent = new SentenceComponent(wordComponentList);

        assertEquals("Hello there.", sentenceComponent.getSymbol());

        assertEquals(3, sentenceComponent.getComponentList().size());

    }

    private WordComponent getWordComponent(String character) {
        List<CharacterComponent> characterComponentList = new ArrayList<>();

        for (char c : character.toCharArray()) {
            characterComponentList.add(new CharacterComponent(c));
        }

        return new WordComponent(characterComponentList);
    }
}