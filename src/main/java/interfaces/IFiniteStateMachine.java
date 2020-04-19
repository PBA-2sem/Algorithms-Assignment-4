/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;


public interface IFiniteStateMachine {

    /**
     * Follow a transition, switch the state of the machine.
     * @param c Char.
     * @return A new finite state machine with the new state.
     */
    IFiniteStateMachine switchState(final CharSequence c);

    /**
     * Is the current state a final one?
     * @return true or false.
     */
    boolean canStop();
}
