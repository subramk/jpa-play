package mistry.CustomAssertion;

import mistry.Matchers.src.main.java.Player;
import org.assertj.core.api.AbstractAssert;

public class PlayerAssert extends AbstractAssert<mistry.CustomAssertion.PlayerAssert, Player> {

    public static mistry.CustomAssertion.PlayerAssert assertThat(Player player){
       return new mistry.CustomAssertion.PlayerAssert(player);
    }

    public PlayerAssert(Player player){
        super(player, mistry.CustomAssertion.PlayerAssert.class);
    }

    public mistry.CustomAssertion.PlayerAssert hasName(String expectedName){

        isNotNull();
        if(!actual.getName().equals(expectedName)){
            failWithMessage("Expected name: " + expectedName + ", but was: " + actual.getName());
        }

        return this;
    }
}
