package com.kesen.design.patten.Observer.frame;

import com.google.common.base.Preconditions;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Auther: kesen
 * @Date: 2020/5/10 20:43
 * @Description:
 **/
public class ObserverRegistry {


	/**
	 * 注册的观察者行为，key:对应被观察者参数类型 value:观察者行为集合
	 */
	private ConcurrentHashMap<Class<?>, CopyOnWriteArraySet<ObserverAction>> registry = new ConcurrentHashMap<>();

	/**
	 * *
	 *
	 * @Description: 注册观察者
	 * @Param: [observer]
	 * @return: void
	 * @Author: kesen
	 * @Date: 2020/5/10 20:43
	 */
	public void register(Object observer) {
		Map<Class<?>, Collection<ObserverAction>> observerActions = findAllObserverActions(observer);
		for (Map.Entry<Class<?>, Collection<ObserverAction>> entry : observerActions.entrySet()) {
			Class<?> eventType = entry.getKey();
			Collection<ObserverAction> eventActions = entry.getValue();
			// 引用
			CopyOnWriteArraySet<ObserverAction> registeredEventActions = registry.get(eventType);
			if (registeredEventActions == null) {
				registry.putIfAbsent(eventType, new CopyOnWriteArraySet<>());
				registeredEventActions = registry.get(eventType);
			}
			registeredEventActions.addAll(eventActions);
		}

	}

	private Map<Class<?>, Collection<ObserverAction>> findAllObserverActions(Object observer) {
		Map<Class<?>, Collection<ObserverAction>> observerActions = new HashMap<>();
		Class clazz = observer.getClass();
		for (Method method : getAnnotatedMethods(clazz)) {
			// 参数类型
			Class<?> eventType = method.getParameterTypes()[0];
			if (!observerActions.containsKey(eventType)) {
				observerActions.put(eventType, new ArrayList<>());
			}
			observerActions.get(eventType).add(new ObserverAction(observer, method));

		}
		return observerActions;
	}


	/**
	 * *
	 *
	 * @Description: 获取观察者类需要通知的行为
	 * @Param: [clazz]
	 * @return: java.util.List<java.lang.reflect.Method>
	 * @Author: kesen
	 * @Date: 2020/5/10 21:08
	 */
	private List<Method> getAnnotatedMethods(Class<?> clazz) {
		List<Method> annotatedMethods = new ArrayList<>();
		for (Method method : clazz.getDeclaredMethods()) {
			if (method.isAnnotationPresent(Subscribe.class)) {
				Class<?>[] parameterTypes = method.getParameterTypes();
				// 检查是否参数长度为1
				Preconditions.checkArgument(parameterTypes.length == 1, "Method %s has @Subscribe annotation but has %s parameters." + "Subscriber methods must have exactly 1 parameter.", method, parameterTypes.length);
				annotatedMethods.add(method);
			}

		}
		return annotatedMethods;
	}


	/**
	** 
	* @Description: 根据被观察者事件类型获取匹配是观察者行为
	* @Param: [event] 
	* @return: java.util.List<com.kesen.design.patten.Observer.frame.ObserverAction> 
	* @Author: kesen
	* @Date: 2020/5/10 21:43 
	*/ 
	public List<ObserverAction> getMatchedObserverActions(Object event) {
		List<ObserverAction> matchedObservers = new ArrayList<>();
		Class<?> postedEventType = event.getClass();
		registry.forEach((key,value) -> {
			if(postedEventType.isAssignableFrom(key)) {
				matchedObservers.addAll(value);
			}
		});

		return  matchedObservers;
	}
	

}
