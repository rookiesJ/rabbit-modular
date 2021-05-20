package com.rookie.rabbit.modular.util;

import com.rookie.rabbit.modular.enums.RabbitArgumentEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rookie
 */
public class RabbitArgumentBuilder {

    private Map<String, Object> args;

    private RabbitArgumentBuilder(){

    }

    public static RabbitArgumentBuilder build() {
        RabbitArgumentBuilder rabbitArgumentBuilder = new RabbitArgumentBuilder();
        rabbitArgumentBuilder.args = new HashMap<>();
        return rabbitArgumentBuilder;
    }

    public RabbitArgumentBuilder addParam(RabbitArgumentEnum rabbitArgumentEnum, Object value) {
        this.args.put(rabbitArgumentEnum.getId(), value);
        return this;
    }

    public Map<String, Object> finish(){
        return this.args;
    }

}
