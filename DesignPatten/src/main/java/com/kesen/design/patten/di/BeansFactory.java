package com.kesen.design.patten.di;

import com.google.common.annotations.VisibleForTesting;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: kesen
 * @Date: 2020/3/22 16:37
 * @Description:
 **/
public class BeansFactory {
	/**
	 * 存放单例对象
	 */
	private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();
	/**
	 * 所有定义的bean
	 */
	private ConcurrentHashMap<String, BeanDefinition> beanDefinitions = new ConcurrentHashMap<>();

	public void addBeanDefinitions(List<BeanDefinition> beanDefinitionList) {
		for (BeanDefinition beanDefinition : beanDefinitionList) {
			this.beanDefinitions.putIfAbsent(beanDefinition.getId(), beanDefinition);
		}

		for (BeanDefinition beanDefinition : beanDefinitionList) {
			if (beanDefinition.isLazyInit() == false && beanDefinition.isSingleton()) {
				createBean(beanDefinition);
			}
		}
	}

	/**
	** 
	* @Description: 根据id在容器中获取对象
	* @Param: [beanId] 
	* @return: java.lang.Object 
	* @Author: kesen
	* @Date: 2020/3/22 17:29
	*/ 
	public Object getBean(String beanId) {
		BeanDefinition beanDefinition = beanDefinitions.get(beanId);
		if (beanDefinition == null) {
			throw new NoSuchBeanDefinitionException("Bean is not defined: " + beanId);
		}
		return createBean(beanDefinition);
	}

	@VisibleForTesting
	protected Object createBean(BeanDefinition beanDefinition) {
		if (beanDefinition.isSingleton() && singletonObjects.contains(beanDefinition.getId())) {
			return singletonObjects.get(beanDefinition.getId());
		}

		Object bean = null;
		try {
			/**
			 * 通过类名加载类
			 */
			Class beanClass = Class.forName(beanDefinition.getClassName());
			/**
			 * 获取配置的属性
			 */
			List<BeanDefinition.ConstructorArg> args = beanDefinition.getConstructorArgs();
			if (args.isEmpty()) {
				// 无参，new 对象
				bean = beanClass.newInstance();
			} else {
				/**
				 * 参数的类型
				 */
				Class[] argClasses = new Class[args.size()];
				/**
				 * 参数
				 */
				Object[] argObjects = new Object[args.size()];
				for (int i = 0; i < args.size(); ++i) {
					BeanDefinition.ConstructorArg arg = args.get(i);
					if (!arg.getIsRef()) {
						argClasses[i] = arg.getType();
						argObjects[i] = arg.getArg();
					} else {
						BeanDefinition refBeanDefinition = beanDefinitions.get(arg.getArg());
						if (refBeanDefinition == null) {
							throw new NoSuchBeanDefinitionException("Bean is not defined: " + arg.getArg());
						}
						argClasses[i] = Class.forName(refBeanDefinition.getClassName());
						// 递归，假如是循环依赖，会抛出异常
						argObjects[i] = createBean(refBeanDefinition);
					}
				}
				bean = beanClass.getConstructor(argClasses).newInstance(argObjects);
			}
		} catch (ClassNotFoundException | IllegalAccessException
				| InstantiationException | NoSuchMethodException | InvocationTargetException e) {
			throw new BeanCreationFailureException("", e);
		}

		if (bean != null && beanDefinition.isSingleton()) {
			singletonObjects.putIfAbsent(beanDefinition.getId(), bean);
			return singletonObjects.get(beanDefinition.getId());
		}
		return bean;
	}
}