/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Fritschtel.cdi.component;

import com.vaadin.flow.component.html.Label;

/**
 *
 * @author xaron
 */
public class MyLabel extends Label {

    public MyLabel(String string) {
        super(string);
        addClassName("label-view");
    }
    
}
