package com.lee.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {
	@Before("PointcutCommon.aPointcut()")
	public void printLog(JoinPoint jp) {
		Object[] args=jp.getArgs();
		String name=jp.getSignature().getName();
		System.out.println("========");
		System.out.println("������ ����� ���۵˴ϴ�!");
		System.out.println("�޼���� : "+name);
		System.out.println("�Ű��������� : "+args[0]);
		System.out.println("========");
	}
}
