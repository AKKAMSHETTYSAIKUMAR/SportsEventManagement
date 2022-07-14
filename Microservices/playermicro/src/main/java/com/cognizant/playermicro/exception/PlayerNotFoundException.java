package com.cognizant.playermicro.exception;

import com.cognizant.playermicro.entity.Player;

public class PlayerNotFoundException extends RuntimeException{

    public PlayerNotFoundException(String msg)
    {
        super(msg);
    }
}
