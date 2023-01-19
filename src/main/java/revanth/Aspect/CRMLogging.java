package revanth.Aspect;



import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CRMLogging {
	
	private Logger mylogger=Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* revanth.controller.*.*(..))")
	public void ControllerAspect() {}
	
	
	@Pointcut("execution(* revanth.DAO.*.*(..))")
	public void DAOAspect() {}
	
	@Pointcut("execution(* revanth.service.*.*(..))")
	public void serviceAspect() {}
	
	@Pointcut("ControllerAspect() || DAOAspect() || serviceAspect()")
	public void appFlow() {}
	
	@Before("appFlow()")
	public void BeforeAdvice(JoinPoint theJoinPoint) {
		
		String sig=theJoinPoint.getSignature().toShortString();
		
		System.out.println("Before ==> "+sig);
		
		Object[] args=theJoinPoint.getArgs();
		
		for(Object temp:args) {
			
			System.out.println("Arguments ==> "+temp);
		}
	}
	
	@AfterReturning(pointcut = "appFlow()",returning = "theResults")
	public void AfterReturning(JoinPoint theJoinpoint,Object theResults) {
		
		String mysig= theJoinpoint.getSignature().toShortString();
		
		System.out.println("After Resturning Result==> "+theResults);
	}

	

}
