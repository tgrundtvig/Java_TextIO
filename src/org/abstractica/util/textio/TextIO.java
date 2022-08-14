package org.abstractica.util.textio;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.abstractica.util.textio.language.TextIOLanguage;

/**
 *
 * @author Tobias Grundtvig
 */
public interface TextIO extends TextOut, TextIn
{
    TextIOLanguage.Language getLanguage();
    int getInteger();
    int getInteger(int min, int max);
    float getFloat();
    float getFloat(float min, float max);
    int selectItem(String preList, Iterable<String> items, String postList);
    int selectItem(String preList, String[] items, String postList);
    boolean getYesOrNo();

    //ToDo
    /*
    int[] selectMultipleItems(String preList, Iterable<String> items, String postList);
    int[] selectMultipleItems(String preList, String[] items, String postList);
    int[] selectMultipleItems(int min, int max, String preList, Iterable<String> items, String postList);
    int[] selectMultipleItems(int min, int max, String preList, String[] items, String postList);
    */

}
