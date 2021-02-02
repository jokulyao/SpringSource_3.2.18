/*
 * Copyright 2002-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.context.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;


/**
 * Indicates one or more resources containing bean definitions to import.
 * 指示要导入的bean定义的一个或多个资源
 *
 * <p>Like {@link Import @Import}, this annotation provides functionality similar to the
 * {@code <import/>} element in Spring XML.  It is typically used when
 * designing {@link Configuration @Configuration} classes to be bootstrapped by
 * {@link AnnotationConfigApplicationContext}, but where some XML functionality such as
 * namespaces is still necessary.
 * 与@Import类似, 这个注解提供的功能与Spring XML中的<import/>类似, 它通常用于设计需要被AnnotationConfigApplicationContext引导的配置类,
 * 但其中有一些XML功能，如名称空间仍然是必要的
 *
 * <p>By default, arguments to the {@link #value()} attribute will be processed using
 * an {@link XmlBeanDefinitionReader}, i.e. it is assumed that resources are Spring
 * {@code <beans/>} XML files.  Optionally, the {@link #reader()} attribute may be
 * supplied, allowing the user to specify a different {@link BeanDefinitionReader}
 * implementation, such as
 * {@link org.springframework.beans.factory.support.PropertiesBeanDefinitionReader}.
 *
 * 默认情况下, value属性的参数将被XmlBeanDefinitionReader进行处理, 即假定资源是Spring XML文件.
 * reader属性可以选择配置不同的BeanDefinitionReader实现, 例如PropertiesBeanDefinitionReader
 * @author Chris Beams
 * @since 3.0
 * @see Configuration
 * @see Import
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface ImportResource {

	/**
	 * Resource paths to import.  Resource-loading prefixes such as {@code classpath:} and
	 * {@code file:}, etc may be used.
	 * 准备导入的资源的路径, 资源前缀类似classpath:和file:等
	 */
	String[] value();

	/**
	 * {@link BeanDefinitionReader} implementation to use when processing resources specified
	 * by the {@link #value()} attribute.
	 * 指定处理value属性指定的资源时要使用的BeanDefinitionReader实现
	 */
	Class<? extends BeanDefinitionReader> reader() default XmlBeanDefinitionReader.class;

}
