/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementations;

import interfaces.IFiniteStateMachine;
import interfaces.IState;

public final class FiniteStateMachine implements IFiniteStateMachine {

    /**
     * Current state.
     */
    private IState current;

    /**
     * Ctor.
     * @param initial Initial state of this machine.
     */
    public FiniteStateMachine(final IState initial) {
        this.current = initial;
    }

    public IFiniteStateMachine switchState(final CharSequence c) {
        return new FiniteStateMachine(this.current.transit(c));
    }

    public boolean canStop() {
        return this.current.isFinal();
    }

}