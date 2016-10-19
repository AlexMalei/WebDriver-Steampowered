package framework;

import org.apache.log4j.Logger;

/**
 * Created by a.maley on 19.10.2016.
 */
public abstract class BaseEntity {
    private Logger logger = Logger.getLogger(BaseEntity.class.getName());

    public void debug(String message){
        logger.debug(message);
    }

    public void info(String message){
        logger.info(message);
    }

    public void error(String message){
        logger.error(message);
    }

    public void warn(String message){
        logger.warn(message);
    }

    public void fatal(String message){
        logger.fatal(message);
    }

    public void trace(String message){
        logger.trace(message);
    }


}
