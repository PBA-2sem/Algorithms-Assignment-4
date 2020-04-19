/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

public interface ITransition {

    /**
     * Is the transition possible with the given character?
     * @param c char.
     * @return true or false.
     */
    boolean isPossible(final CharSequence c);

    /**
     * The state to which this transition leads.
     * @return State.
     */
    IState state();
}
