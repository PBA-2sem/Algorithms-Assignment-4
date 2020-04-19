/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementations;

import java.util.ArrayList;
import java.util.List;
import interfaces.IState;
import interfaces.ITransition;

/**
 * State in a finite state machine.
 */
public final class State implements IState {

    private List<ITransition> transitions;
    private boolean isFinal;

    public State() {
        this(false);
    }
    
    public State(final boolean isFinal) {
        this.transitions = new ArrayList<>();
        this.isFinal = isFinal;
    }

    public IState transit(final CharSequence c) {
        return transitions
          .stream()
          .filter(t -> t.isPossible(c))
          .map(ITransition::state)
          .findAny()
          .orElseThrow(() -> new IllegalArgumentException("Input not accepted: " + c));
    }

    public boolean isFinal() {
        return this.isFinal;
    }

    @Override
    public IState with(ITransition tr) {
        this.transitions.add(tr);
        return this;
        
        
    }

}
