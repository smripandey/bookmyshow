package com.bms.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Aspect
@Component
public class LoggingAspect {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	

	//execution(* com.bms.*.*.*(..)) -->All package classes with sub package classes and methods
	@Pointcut(value="execution(* com.bms.*.*.*(..))")
	public void myPointcut(){

	}

	@Around("myPointcut()")
	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable{
		ObjectMapper mapper=new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		String methodName=pjp.getSignature().getName();
		String className=pjp.getTarget().getClass().toString();
		Object[] array=pjp.getArgs();
		log.info("method invoked :- "+className+" : "+methodName+"()"+" arguments : "+mapper.writeValueAsString(array));
		Object object=pjp.proceed();
		log.info(className+" : "+methodName+"()"+" Response : "+mapper.writeValueAsString(object));
		return object;
	}
		
	@Before("execution(* com.bms.service.BookingServiceImpl.createBooking(..))")
	public void initiateBooking() {
		log.info("Booking process initiated------");
		log.info("Checking if the given seats are available or booked. ");
	}
	
	@After("execution(* com.bms.service.BookingServiceImpl.createBooking(..))")
	public void bookingCompleted() {
		log.info("It's confirmed. Thank You for booking with us!!!!");
	}
	
	@Before("execution(* com.bms.service.GenericServiceImpl.createPayment(..))")
	public void initiatePayment() {
		log.info("Initiating payment for this booking...payment is done with dummy data");
	}
	
	@After("execution(* com.bms.service.GenericServiceImpl.createPayment(..))")
	public void afterPayment() {
		log.info("Payment successful. Updating payment id in booking.");
	}
	
	@Before("execution(* com.bms.service.BookingServiceImpl.cancelBooking(..))")
	public void beforeCancellation() {
		log.info("Booking cancellation process initiated----");
		log.info("Releasing booked seats.");
	}
	
	@After("execution(* com.bms.service.BookingServiceImpl.cancelBooking(..))")
	public void afterCancellation() {
		log.info("Booking cancelled----");
	}
	
	@Before("execution(* com.bms.service.BookingServiceImpl.getBooking(..))")
	public void getBooking() {
		log.info("Retrieving booking details for user------------");
	}
	
	@Before("execution(* com.bms.service.BookingServiceImpl.getAllBookings(..))")
	public void getAllBookings() {
		log.info("Retrieving all booking details for a user--------");
	}
	
}
