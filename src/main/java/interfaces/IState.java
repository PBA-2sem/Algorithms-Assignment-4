/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

public interface IState {

    /**
     * Add a Transition to this state.
     * @param tr Given transition.
     * @return Modified State.
     */
    IState with(final ITransition tr);

    /**
     * Follow one of the transitions, to get 
     * to the next state.
     * @param c Character.
     * @return State.
     * @throws IllegalStateException if the char is not accepted.
     */
    IState transit(final CharSequence c);
    
    /**
     * Can the automaton stop on this state?
     * @return true or false
     */
    boolean isFinal();
}
