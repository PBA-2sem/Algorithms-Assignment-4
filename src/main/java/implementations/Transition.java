/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementations;

import interfaces.IState;
import interfaces.ITransition;

public final class Transition implements ITransition {

    private String rule;
    private IState next;
    
    /**
     * Ctor.
     * @param rule Rule that a character has to meet 
     *  in order to get to the next state.  
     * @param next Next state.
     */
    public Transition (String rule, IState next) {
        this.rule = rule;
        this.next = next;
    }
    
    public IState state() {
        return this.next;
    }

    public boolean isPossible(CharSequence c) {
        return this.rule.equalsIgnoreCase(String.valueOf(c));
    }

}
