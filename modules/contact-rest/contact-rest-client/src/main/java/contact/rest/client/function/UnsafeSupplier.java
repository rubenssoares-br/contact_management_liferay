package contact.rest.client.function;

import javax.annotation.Generated;

/**
 * @author Rubens Soares
 * @generated
 */
@FunctionalInterface
@Generated("")
public interface UnsafeSupplier<T, E extends Throwable> {

	public T get() throws E;

}