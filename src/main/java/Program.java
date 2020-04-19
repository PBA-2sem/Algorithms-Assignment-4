/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Orchi
 */

import implementations.FiniteStateMachine;
import implementations.State;
import implementations.Transition;
import interfaces.IFiniteStateMachine;
import interfaces.IState;
import java.util.regex.*;  

public class Program {

    public static void main(String args[]) {
        // ##################### TASK 1 #####################
        System.out.println(matcher(".sa.", "hsas"));
        
        // ##################### TASK 2 #####################
        String json = "{\"key\":\"value\"}";
        IFiniteStateMachine machine = buildJsonStateMachine();
        for (int i = 0; i < json.length(); i++) {
            machine = machine.switchState(String.valueOf(json.charAt(i)));
        }
        if (machine.canStop())
            System.out.println("Success");
        else
            System.out.println("Failure");
    }
    
    public static boolean matcher(String regex, String input) {
        return Pattern.compile(regex).matcher(input).matches();
    }
    
    private static FiniteStateMachine buildJsonStateMachine() {
        IState first = new State();
        IState second = new State();
        IState third = new State();
        IState fourth = new State();
        IState fifth = new State();
        IState sixth = new State();
        IState seventh = new State();
        IState eighth = new State(true);

        first.with(new Transition("{", second));
        second.with(new Transition("\"", third));
        //Add transitions with chars 0-9 and a-z
        for (int i = 0; i < 26; i++) {
            if (i < 10) {
                third = third.with(new Transition(String.valueOf(i), third));
                sixth = sixth.with(new Transition(String.valueOf(i), sixth));
            }
            third = third.with(new Transition(String.valueOf((char) ('a' + i)), third));
            sixth = sixth.with(new Transition(String.valueOf((char) ('a' + i)), sixth));
        }
        third.with(new Transition("\"", fourth));
        fourth.with(new Transition(":", fifth));
        fifth.with(new Transition("\"", sixth));
        sixth.with(new Transition("\"", seventh));
        seventh.with(new Transition(",", second));
        seventh.with(new Transition("}", eighth));
        return new FiniteStateMachine(first);
    }
    
}

