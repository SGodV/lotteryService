package cn.edu.zucc.cxw.lottery.aop;

import cn.edu.zucc.cxw.lottery.exception.CheckException;
import cn.edu.zucc.cxw.lottery.exception.UnloginException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import cn.edu.zucc.cxw.lottery.entity.ResultBean;

@Aspect
@Component
public class ControllerAOP {
    private final static Log logger = LogFactory.getLog(ControllerAOP.class);

    //切入 所有返回ResultBean的 方法
    @Pointcut("execution(public  cn.edu.zucc.cxw.lottery.entity.ResultBean *(..))")
    private void pointCut(){ }

    @Around("pointCut()")
    public Object handlerControllerMethod(ProceedingJoinPoint pjp) {
        long startTime = System.currentTimeMillis();

        ResultBean<?> result;

        try {
            result = (ResultBean<?>) pjp.proceed();
            logger.info(pjp.getSignature() + "use time:" + (System.currentTimeMillis() - startTime));
        } catch (Throwable e) {
            result = handlerException(pjp, e);
        }
        return result;
    }
    private ResultBean<?> handlerException(ProceedingJoinPoint pjp, Throwable e) {
        ResultBean<?> result = new ResultBean();

        // 已知异常
        if (e instanceof CheckException) {
            result.setMsg(e.getLocalizedMessage());
            result.setCode(ResultBean.FAIL);
        } else if (e instanceof UnloginException) {
            result.setMsg("Unlogin");
            result.setCode(ResultBean.NO_LOGIN);
        } else {
            logger.error(pjp.getSignature() + " error ", e);
            //TODO 未知的异常，应该格外注意，可以发送邮件通知等
            result.setMsg(e.toString());
            result.setCode(ResultBean.FAIL);
        }
//        e.printStackTrace();
        return result;
    }
}
