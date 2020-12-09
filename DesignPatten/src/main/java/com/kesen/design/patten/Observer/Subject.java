package com.kesen.design.patten.Observer;

public interface Subject {
	void registerObserver(Observer observer);

	void removeObserver(Observer observer);

	void notifyObservers(Message message);
}