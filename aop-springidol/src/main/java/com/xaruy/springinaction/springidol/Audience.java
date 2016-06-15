package com.xaruy.springinaction.springidol;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * �����ඨ������֪ͨ
 * @author xaruy
 *
 */
@Component
@Aspect  //ע�ⶨ������
public class Audience {
	
	//�����е�
	@Pointcut("execution(* com.xaruy.springinaction.springidol.Performer.perform(..))")
	public void performance(){}
	
	@Before("performance()")
	public void takeSeats() {   //����֮ǰ ��λ��
		System.out.println("The audience is taking their seats.");
	}
	
	@Before("performance()")
	public void turnOffCellPhones() {   //����֮ǰ���ֻ�
		System.out.println("The audience is turning off their cellphones");
	}
	
	@AfterReturning("performance()")
	public void applaud() {  //���ݳɹ�֮�����
		System.out.println("CLAP CLAP CLAP");
	}
	
	@AfterThrowing("performance()")
	public void demandRefund() {  //����ʧ�ܣ�Ҫ����Ǯ
		System.out.println("Boo! We want our money back!");
	}
	
	@Around("performance()")  //ע�⻷��֪ͨ
	public void watchPerFormance(ProceedingJoinPoint joinpoint) {
		try {
			System.out.println("The audience is start time");
			long start = System.currentTimeMillis();//����ǰ��ʼ��ʱ
			
			joinpoint.proceed(); //ִ�б�֪ͨ����
			
			long end = System.currentTimeMillis(); //���ݳɹ�֮���ʱ
			System.out.println("The performance took " + (end - start) + " milliseconds");
		} catch (Throwable t) {
			System.out.println("Boo! Boo!");
		}
	}

}
