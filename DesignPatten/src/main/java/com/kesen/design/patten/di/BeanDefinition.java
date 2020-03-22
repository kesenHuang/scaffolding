package com.kesen.design.patten.di;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: kesen
 * @Date: 2020/3/22 16:28
 * @Description:
 **/
public class BeanDefinition {
	/**
	 * 对象ID
	 */
	private String id;
	/**
	 * className全限名称
	 */
	private String className;
	/**
	 * 构造参数
	 */
	private List constructorArgs = new ArrayList<>();
	/**
	 * 对象类型：单例/非单例
	 */
	private Scope scope = Scope.SINGLETON;
	/**
	 * 是否延迟加载
	 */
	private boolean lazyInit = false;


	public BeanDefinition(String id, String className) {
		this.id = id;
		this.className = className;
	}

	public void addConstructorArg(ConstructorArg constructorArg) {
		this.constructorArgs.add(constructorArg);
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List getConstructorArgs() {
		return constructorArgs;
	}

	public void setConstructorArgs(List constructorArgs) {
		this.constructorArgs = constructorArgs;
	}

	public Scope getScope() {
		return scope;
	}

	public void setScope(Scope scope) {
		this.scope = scope;
	}

	public boolean isLazyInit() {
		return lazyInit;
	}

	public void setLazyInit(boolean lazyInit) {
		this.lazyInit = lazyInit;
	}

	public boolean isSingleton() {
		return scope.equals(Scope.SINGLETON);
	}

	public static enum Scope {SINGLETON, PROTOTYPE}

	public static class ConstructorArg {
		/**
		 * 是否有依赖
		 */
		private boolean isRef;
		/**
		 * 参数类型
		 */
		private Class type;
		/**
		 * 参数
		 */
		private Object arg; // 省略必要的getter/setter/constructors


		/**
		 * 内部静态类，可以访问私有构造函数？
		 */
		private ConstructorArg(Builder builder) {
			this.isRef = builder.isRef;
			this.type = builder.type;
			this.arg = builder.arg;
		}

		/**
		 * 建造者模式
 		 */
		public static class Builder {
			private boolean isRef = false;
			private Class type;
			private Object arg;

			public Builder setRef(Boolean isRef) {
				this.isRef = isRef;
				return this;
			}

			public Builder setType(Class type) {
				this.type = type;
				return this;
			}

			public Builder setArg(Object arg) {
				this.arg = arg;
				return this;
			}

			public ConstructorArg build() {
				if (this.isRef) {
					if (this.type != null) {
						throw new IllegalArgumentException("当参数为引用类型时，无需设置 type 参数");
					}

					// null 是 string 实例？
					if (!(arg instanceof String)) {
						throw new IllegalArgumentException("请设置引用 ID");
					}
				} else {
					if (this.type == null || this.arg == null) {
						throw new IllegalArgumentException("当参数为非引用类型时，type 和 arg 参数必填");
					}
				}

				return new ConstructorArg(this);
			}

			// Getter
			public boolean getIsRef() {
				return isRef;
			}

			public Class getType() {
				return type;
			}

			public Object getArg() {
				return arg;
			}

		}

		public boolean getIsRef() {
			return isRef;
		}

		public void setIsRef(boolean ref) {
			isRef = ref;
		}

		public Class getType() {
			return type;
		}

		public void setType(Class type) {
			this.type = type;
		}

		public Object getArg() {
			return arg;
		}

		public void setArg(Object arg) {
			this.arg = arg;
		}
	}


}

