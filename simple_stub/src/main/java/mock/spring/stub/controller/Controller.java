package mock.spring.stub.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping()
public class Controller {

    //DOCKER_ENV_TIMER_MIN  DOCKER_ENV_TIMER_MAX переменые которые необходимо указать в ENV в контейнере Docker

    @Value("${DOCKER_ENV_TIMER_MIN:100}")
    private String docker_env_timer_min;

    @Value("${DOCKER_ENV_TIMER_MAX:200}")
    private String docker_env_timer_max;

    @RequestMapping("/**")
    public String getAny() throws InterruptedException {
        Thread.sleep(
                (long) (Math.random() * (
                                        Integer.parseInt(
                                                docker_env_timer_max
                                        ) - Integer.parseInt(
                                                docker_env_timer_min
                                        )
                                ) + Integer.parseInt(
                                        docker_env_timer_min
                                ))
        );
        System.out.println("timerMin - " + docker_env_timer_min + "; timerMax - " + docker_env_timer_max);
        return ("Code 200");
    }


}
