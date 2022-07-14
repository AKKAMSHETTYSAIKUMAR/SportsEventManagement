package com.cognizant.playermicro.exception;

import com.cognizant.playermicro.entity.Player;

public class PlayerAdditionException extends RuntimeException{

    public PlayerAdditionException(String msg)
    {
        super(msg);
    }

}
