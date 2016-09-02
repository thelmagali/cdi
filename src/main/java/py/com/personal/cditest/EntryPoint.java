package py.com.personal.cditest;
import org.jboss.weld.environment.se.events.ContainerInitialized;
import py.com.personal.bc.common.sockets.SocketServer;
import py.com.personal.cditest.business.CreditTransaction;
import py.com.personal.cditest.business.DebitTransaction;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

public class EntryPoint{

    @Inject
    SocketServer socketServer;

    public void init(@Observes ContainerInitialized containerInitialized) throws Exception{
		socketServer.run();
    }

}