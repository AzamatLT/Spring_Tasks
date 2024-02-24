package mock.postgresql.multi_pg.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class ServiceMock {

    Logger logger = LoggerFactory.getLogger(ServiceMock.class);


    @Async
    public String saveUsers(String name) {

        return name + "_" + name;
    }


}
