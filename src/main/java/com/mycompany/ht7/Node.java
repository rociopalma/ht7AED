/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ht7;

import java.util.Optional;

/**
 *
 * @author Rocío
 * @param <T>
 */
public class Node<T> {

    private T key;
    private Node left;
    private Node right;

    String espanol;
    String ingles;
    String frances;

    public Node(T key, String espanol, String ingles, String frances) {
        this.key = key;
        this.espanol = espanol;
        this.ingles = ingles;
        this.frances = frances;
    }

    public void add(T key, String espanol, String ingles, String frances) {
        if ((int) key < (int) this.key) {
            if (left != null) {
                left.add(key, espanol, ingles, frances);
            } else {
                left = new Node(key, espanol, ingles, frances);
            }
        } else {
            if (right != null) {
                right.add(key, espanol, ingles, frances);
            } else {
                right = new Node(key, espanol, ingles, frances);
            }
        }
    }

    public Optional<Node> find(T value) {
        if ((int)value == (int)this.key) {
            return Optional.of(this);
        } else if ((int) value < (int) this.key) {
            if (this.left != null) {
                return this.left.find(value);
            } else {
                return Optional.empty();
            }
        } else {
            if (this.right != null) {
                return this.right.find(value);
            } else {
                return Optional.empty();
            }
        }
    }

    public String getEspanol() {
        return espanol;
    }

    public String getIngles() {
        return ingles;
    }

    public String getFrances() {
        return frances;
    }
    
    

    @Override
    public String toString() {

        return "Key:" + espanol + "\n Data:\nSpanish: " + espanol + "\nInglis: " + ingles + "\nFrensh: " + frances + "\nLeft: " + left + "\nRigth: " + right;
    }
}
