package com.mrl.spring.aop.impl;

import org.springframework.core.annotation.Order;

//使用@Order 指定切面优先级 值越小，优先级越高
@Order(1)
public class ValidationAspect {

}
