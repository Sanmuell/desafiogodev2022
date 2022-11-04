/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import java.util.function.Supplier;

import br.com.senior.messaging.IMessenger;

public class InstanceMessengerSupplier implements Supplier<IMessenger> {

	private final IMessenger messenger;

	public InstanceMessengerSupplier(IMessenger messenger) {
		this.messenger = messenger;
	}

	@Override
	public IMessenger get() {
		return messenger;
	}

}
